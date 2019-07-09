package commonMethods;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class commonAction {

	private AndroidDriver driver;
	 
    public commonAction (AndroidDriver driver) {
        this.driver = driver;
    }
 
    //Tap to an element for 250 milliseconds
    public void tapByElement (AndroidElement androidElement) {
        new TouchAction(driver)
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).perform();
    }
 
    //Tap by coordinates
    public void tapByCoordinates (int x,  int y) {
        new TouchAction(driver)
                .tap(TapOptions.tapOptions().withPosition(PointOption.point(x,y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250))).perform();
    }
 
    //Press by element
    public void pressByElement (AndroidElement element, long seconds) {
        new TouchAction(driver)
                .press(ElementOption.element(element))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .release()
                .perform();
    }
 
    //Press by coordinates
    public void pressByCoordinates (int x, int y, long seconds) {
        new TouchAction(driver)
                .press(PointOption.point(x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .release()
                .perform();
    }
 
    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) 
    {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
 
        new TouchAction(driver)
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release().perform();
    }
 
    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
 
        new TouchAction(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }
 
    //Swipe by elements
    public void swipeByElements (AndroidElement startElement, AndroidElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
 
        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);
 
        new TouchAction(driver)
                .press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
 
    //Multitouch action by using an android element
    public void multiTouchByElement (AndroidElement androidElement) {
        TouchAction press = new TouchAction(driver)
                .press(ElementOption.element(androidElement))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .release();
 
        new MultiTouchAction(driver)
                .add(press)
                .perform();
    }
}
