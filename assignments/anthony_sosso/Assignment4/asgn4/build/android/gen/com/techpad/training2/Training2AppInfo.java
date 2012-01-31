package com.techpad.training2;

import org.appcelerator.titanium.ITiAppInfo;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;
import org.appcelerator.kroll.common.Log;

/* GENERATED CODE
 * Warning - this class was generated from your application's tiapp.xml
 * Any changes you make here will be overwritten
 */
public final class Training2AppInfo implements ITiAppInfo
{
	private static final String LCAT = "AppInfo";
	
	public Training2AppInfo(TiApplication app) {
		TiProperties properties = app.getSystemProperties();
					
					properties.setString("ti.facebook.appid", "224569824219773");
					
					properties.setString("ti.deploytype", "development");
	}
	
	public String getId() {
		return "com.techpad.training2";
	}
	
	public String getName() {
		return "Training2";
	}
	
	public String getVersion() {
		return "1.0";
	}
	
	public String getPublisher() {
		return "administrator";
	}
	
	public String getUrl() {
		return "http://www.techpad.org";
	}
	
	public String getCopyright() {
		return "2011 by administrator";
	}
	
	public String getDescription() {
		return "not specified";
	}
	
	public String getIcon() {
		return "default_app_icon.png";
	}
	
	public boolean isAnalyticsEnabled() {
		return false;
	}
	
	public String getGUID() {
		return "9727ad5d-6cf4-4471-ad38-81fbee70f02c";
	}
	
	public boolean isFullscreen() {
		return false;
	}
	
	public boolean isNavBarHidden() {
		return false;
	}
}
