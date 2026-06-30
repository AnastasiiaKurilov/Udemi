package org.AppleTests.Apple;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.udemi.PageObject.Utiles.IOSClassActions;

public class AllertViewsPage extends IOSClassActions {
    IOSDriver driver;
    public AllertViewsPage(IOSDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
////select Text Entry with IOS class chain
//        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name =='Text Entry'`]")).click();
    @iOSXCUITFindBy (iOSClassChain = "**/XCUIElementTypeStaticText[`name =='Text Entry'`]")
    private WebElement TextEntry;

   //  driver.findElement(AppiumBy.className("XCUIElementTypeTextField")).sendKeys("Anastasia Marquis");
    @iOSXCUITFindBy(className= "XCUIElementTypeTextField")
            private WebElement name;
    //select Ok button
       // driver.findElement(AppiumBy.accessibilityId("OK")).click();
    @iOSXCUITFindBy(accessibility = "OK")
    private  WebElement okey;
    /////  ///confirm/cancel
@iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name=='Confirm / Cancel'")
    private WebElement confirmAndcancel;
//messege
//String element=driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH'A message'")).getText();
//        System.out.println("Text: "+element);
//        Assert.assertEquals(element,"A message should be a short, complete sentence.");
@iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'A message'")
    private WebElement messege;

//        //select confirm
//        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm / Cancel'")).click();
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Confirm / Cancel'")
    private WebElement submit;

    public void fillText(String ourName) {
   TextEntry.click();
   name.sendKeys(ourName);
   okey.click();
    }
    // driver.findElement(AppiumBy.iOSNsPredicateString("type=='XCUIElementTypeStaticText' AND name=='Confirm / Cancel'")).click();
    //       String element=driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH'A message'")).getText();
    //        System.out.println("Text: "+element);
    //        Assert.assertEquals(element,"A message should be a short, complete sentence.");
    //        //select confirm
    //        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm / Cancel'")).click();
public String getConfirmMessege(){
    confirmAndcancel.click();        // 1. open the dialog
    String text = messege.getText(); // 2. read message WHILE dialog is open
    submit.click();                  // 3. then close it
    return text;

    }
}


