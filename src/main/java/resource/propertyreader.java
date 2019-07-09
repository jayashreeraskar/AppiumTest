 package resource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertyreader 
{
	private Properties properties;
	
	 private final String propertyFilePath= System.getProperty("user.dir")+"\\Config\\devicecapablity.properties";
	 public propertyreader(){
	 BufferedReader reader;
	 try {
	 
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 public String getAppPath(){
	 String appPath = properties.getProperty("apppath");
	 if(appPath!= null) return appPath;
	 else throw new RuntimeException("apppath not specified in the properties file."); 
	 }
	 
	 public long getImplicitlyWait() { 
	 String implicitlyWait = properties.getProperty("implicitlyWait");
	 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
	 else throw new RuntimeException("implicitlyWait not specified in the properties file."); 
	 }
	 
	 public String getApplicationUrl() {
	 String url = properties.getProperty("url");
	 if(url != null) return url;
	 else throw new RuntimeException("url not specified in the properties file.");
	 }	
	 public String getPlatform() {
		 String platform = properties.getProperty("platform");
		 if(platform != null) return platform;
		 else throw new RuntimeException("platform not specified in the properties file.");
		 }	

	 
	 
	 public String getDeviceName() {
		 String devicename = properties.getProperty("devicename");
		 if(devicename != null) return devicename;
		 else throw new RuntimeException("devicename not specified in the properties file.");
		 }	
	 
	 public String getpackageName() {
		 String devicename = properties.getProperty("package");
		 if(devicename != null) return devicename;
		 else throw new RuntimeException("packagename not specified in the properties file.");
		 }	
	 
	 public String getactivityName() {
		 String devicename = properties.getProperty("activity");
		 if(devicename != null) return devicename;
		 else throw new RuntimeException("packagename not specified in the properties file.");
		 }	

}
