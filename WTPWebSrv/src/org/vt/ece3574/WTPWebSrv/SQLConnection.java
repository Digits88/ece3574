package org.vt.ece3574.WTPWebSrv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLConnection {
	
	private Connection con;
	
	public SQLConnection()
	{
		
	}
	
	public static void closeRS(ResultSet rs)
	{
        try {
            rs.close();
            
        } catch (Exception ex) {
        	Error.log("Failed to close result set");
        	ex.printStackTrace(Error.getPrintWriter());
        }
	}
	
	public void close()
	{
        try {
            con.close();
            
        } catch (Exception ex) {
        	Error.log("Failed to close connection");
        	ex.printStackTrace(Error.getPrintWriter());
        }
	}
	
	public ResultSet doQuery(String query)
	{
        Statement st = null;
        ResultSet rs = null;

        try {
        	
            st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (Exception ex) {
        	Error.log("Query failed: " + query);
        	ex.printStackTrace(Error.getPrintWriter());
        }
        
        return rs;
	}
	
	public void openConnection()
	{

        String url = "jdbc:mysql://localhost:3306/WTPARTY";
        String user = "WTPARTYSQL";
        String password = "ECE3574";

        try {
            con = DriverManager.getConnection(url, user, password);

        } catch (Exception ex) {
        	Error.log("Failed to open connection");
        	ex.printStackTrace(Error.getPrintWriter());
        }
        

	}

}
