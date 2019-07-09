package commonMethods;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import Manager.manager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import resource.StartAppiumServer;

public class BaseClass 
{
	
	    protected AndroidDriver driver;
	    protected WebDriverWait wait;
	    protected commonAction mobileActions;
	 
	    public  BaseClass()
	    {
	    	
	    }
	    //Constructor
	    public BaseClass (AndroidDriver driver){
	        this.driver = driver;
	        mobileActions = new commonAction(driver); //We are using MobileActions with this instance. Composition.
	        wait = new WebDriverWait(driver, 20);
	    }
	    	
	    
	    public AndroidDriver getdriver() throws IOException
	    {
			 DesiredCapabilities dc=new DesiredCapabilities();

	  
	    dc.setCapability(MobileCapabilityType.DEVICE_NAME,manager.getInstance().getConfigReader().getDeviceName());
	    dc.setCapability("autoGrantPermissions", true);
	    dc.setCapability("autoDismissAlerts", true);

	    //dc.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
	    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,manager.getInstance().getConfigReader().getpackageName());
	    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,manager.getInstance().getConfigReader().getactivityName());
	   /* Runtime.getRuntime().exec("adb shell am start -n io.appium.unlock/.Unlock");
	    Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_POWER");
	    Runtime.getRuntime().exec("adb shell input swipe 800 400 400 400");
	    Runtime.getRuntime().exec("adb shell input text 159632");
	    Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_POWER");
*/


	    driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	    
}
	    public static void main(String args[]) throws InterruptedException, IOException
	    {
	    	StartAppiumServer ss=new StartAppiumServer();
	    	ss.startServer();
	    	BaseClass bc=new BaseClass();
	    	bc.getdriver();
	    	ss.stopServer();
	    	
	    	
	    }
}