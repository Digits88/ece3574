package org.vt.ece3574.WTPWebSrv;

import java.io.PrintWriter;

public class Error {
	
	private static Error instance;
	private PrintWriter w;
	
	private Error(PrintWriter writer)
	{
		w = writer;
	}
	
	private void insLog(String message)
	{
		w.write(message + "\n");
	}
	
	public static void init(PrintWriter writer)
	{
		instance = new Error(writer);
	}
	
	public static void log(String message)
	{
		if(instance!=null)
			instance.insLog(message);
	}
	
	public static PrintWriter getPrintWriter()
	{
		if(instance!=null)
			return instance.w;
		return null;
	}

}
