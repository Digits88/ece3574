package org.vt.ece3574.WTPWebSrv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.net.URLDecoder;
import org.ece3574.WTParty.*;

/**
 * Servlet implementation class TestServer
 */
public class TestServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter res = response.getWriter();
		Error.init(res);
		String command  = request.getParameter("command");
		
		if(command==null)
		{
			error("Error: command missing.", response);
		}
		else if(command.equals("geocode"))
		{
			String input = request.getParameter("input");
			if(input==null)
			{
				error("Error: geocode requires input parameter.", response);
			}
			else
			{
				input = URLDecoder.decode(input, "US-ASCII");
				GeoLocation loc = GeoCoder.geoCode(input);
				if(loc!=null)
				{
					res.write(loc.toString());
				}
				else
				{
					res.write("NOT FOUND");
				}
			}
		}
		else
		{
			error("Error: command not recognized.", response);
		}
	}
	
	private void error(String message, HttpServletResponse response) throws IOException
	{
		response.setStatus(500);
		response.getWriter().write(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
