package org.vt.ece3574.WTPWebSrv;

import java.sql.*;

import org.ece3574.WTParty.GeoLocation;

public class GeoCoder {

	
	public static GeoLocation geoCode(String input)
	{
		input=input.toUpperCase();
		
		int numeric=-1;
		
		String[] tokens = input.split(" ");
		
		
		for(String s: tokens)
		{
			try
			{
				numeric = Integer.parseInt(s);
			}
			catch(NumberFormatException e)
			{
				
			}
		}
		
		String searchKey=input.replaceAll("[\\s\\.,0-9]+", "");
		
		
		return getBySQL(searchKey, numeric);	
		
	}
	
	private static GeoLocation getBySQL(String search, int numeric)
	{
		
		SQLConnection con = new SQLConnection();
		con.openConnection();
		ResultSet rs = null;
		GeoLocation loc = null;
		try
		{
			rs = con.doQuery("SELECT APT_COMPLEXES.ID, NAME, LAT, LON FROM APT_SEARCH_TERMS LEFT JOIN APT_COMPLEXES ON APT_COMPLEXES.ID = APT_SEARCH_TERMS.COMP_ID WHERE TERM='" + search + "'");
			if(rs.next())
			{
				int complexID = rs.getInt("ID");
				String complexName = rs.getString("NAME");
				loc = new GeoLocation(complexName, rs.getInt("LAT"), rs.getInt("LON"));
				
				if(numeric!=-1)
				{
					rs.close();
					rs = con.doQuery("SELECT LAT, LON FROM APT_UNITS WHERE COMPLEX_ID=" + complexID + " AND UNIT_NUMBER=" + numeric);
					if(rs.next())
					{
						loc = new GeoLocation(numeric + " " + complexName, rs.getInt("LAT"), rs.getInt("LON"));
					}
				}
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace(Error.getPrintWriter());
			return null;
		}
		finally
		{
			SQLConnection.closeRS(rs);
			con.close();
		}
		return loc;
		
	}
	
	 
}
