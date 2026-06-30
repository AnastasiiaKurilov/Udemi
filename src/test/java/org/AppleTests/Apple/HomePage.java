package org.AppleTests.Apple;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.udemi.PageObject.Utiles.IOSClassActions;

public class HomePage extends IOSClassActions {
    IOSDriver driver;
    public HomePage(IOSDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    //select alert view
      //  driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    @iOSXCUITFindBy(accessibility="Alert Views")
    private WebElement allertViews;
public AllertViewsPage setAllertView(){
    allertViews.click();
    return new AllertViewsPage(driver);

}


}
