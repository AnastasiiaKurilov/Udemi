package org.AndroidTests.Android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.udemi.PageObject.Utiles.AndroidClassActions;

/**
 * Hello world!
 *
 */
public class FormPage extends AndroidClassActions {
   AndroidDriver driver;
    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
///   driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anastasiia Marquis");
 @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
 private WebElement nameField;
///   driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
private WebElement genderFemale;

@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
private WebElement genderMale;

@AndroidFindBy(id="android:id/text1")
private WebElement countrySelection;

@AndroidFindBy (id="com.androidsample.generalstore:id/btnLetsShop")
private  WebElement LetsShop;
// action methods
    public  void setNameField(String name){
nameField.sendKeys(name);
driver.hideKeyboard();
    }
    public void setGender(String gender) {
        if (gender.contains("Female"))
       genderFemale.click();
       else
            genderMale.click();
    }
    public void  countrySelect(String country){
        countrySelection.click();

    }
    public void setCountrySelection(String countryName){
countrySelection.click();
scrollToText(countryName);
driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }
    public void setActivity(){
            driver.terminateApp("com.androidsample.generalstore");
            driver.executeScript("mobile: startActivity", ImmutableMap.of(
                    "intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"
            ));
    }
public productCatalogue setLetsGoButton(){
        LetsShop.click();
        return new productCatalogue(driver);
}
}
