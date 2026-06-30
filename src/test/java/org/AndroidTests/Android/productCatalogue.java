package org.AndroidTests.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.udemi.PageObject.Utiles.AndroidClassActions;

import java.util.List;

public class productCatalogue extends AndroidClassActions {
    AndroidDriver driver;
public productCatalogue(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
private List<WebElement> addToCart;

@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
private WebElement cartbutton;

//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click()
//   driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
// driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
public void addItemToCartByIndex(int index){
addToCart.get(index).click();
}
public CartPage setCartbutton() throws InterruptedException {
    cartbutton.click();
    Thread.sleep(2000);
    return new CartPage(driver);
}

}



