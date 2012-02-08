package org.vt.ece3574.mibarraAssignment4;

import org.appcelerator.titanium.ITiAppInfo;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;
import org.appcelerator.kroll.common.Log;

/* GENERATED CODE
 * Warning - this class was generated from your application's tiapp.xml
 * Any changes you make here will be overwritten
 */
public final class SocialToDoAppInfo implements ITiAppInfo
{
	private static final String LCAT = "AppInfo";
	
	public SocialToDoAppInfo(TiApplication app) {
		TiProperties properties = app.getSystemProperties();
					
					properties.setString("ti.deploytype", "test");
	}
	
	public String getId() {
		return "org.vt.ece3574.mibarraAssignment4";
	}
	
	public String getName() {
		return "Social To Do";
	}
	
	public String getVersion() {
		return "1.0";
	}
	
	public String getPublisher() {
		return "Matthew Ibarra";
	}
	
	public String getUrl() {
		return "http://www.code.google.com/p/ece3574/";
	}
	
	public String getCopyright() {
		return "not specified";
	}
	
	public String getDescription() {
		return "not specified";
	}
	
	public String getIcon() {
		return "appicon.png";
	}
	
	public boolean isAnalyticsEnabled() {
		return true;
	}
	
	public String getGUID() {
		return "5a36c341-60f9-4206-8c10-bbb5fab9e26c";
	}
	
	public boolean isFullscreen() {
		return false;
	}
	
	public boolean isNavBarHidden() {
		return false;
	}
}
