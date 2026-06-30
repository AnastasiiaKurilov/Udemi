package org.AndroidTests.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.udemi.PageObject.Utiles.AndroidClassActions;

import java.util.List;

public class CartPage extends AndroidClassActions {
    AndroidDriver driver;
    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    private List<WebElement> product_priceList;

@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totaAmount;

@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle")
    private  WebElement titleAlertCart;

@AndroidFindBy(id= "android:id/button1")
    private  WebElement closeCartButton;

@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
   public  WebElement terms;

@AndroidFindBy(className = "android.widget.CheckBox")
   public WebElement checkBoxbutton;

@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    public WebElement proceedButton;
public  List<WebElement> getProduct_priceList()
{
    return product_priceList;
}
public double getproductSum(){
   int product_count=product_priceList.size();
   double sum =0;
   for (int i=0;i<product_count;i++){
       String amountString=product_priceList.get(i).getText();
       Double totalPrice = getFormattedAmount(amountString);
       sum = sum + totalPrice;
   }

    return sum;
}
public Double getTotalAmountDisplayed(){
    return getFormattedAmount(totaAmount.getText());
}
public void acceeptTermsConditions(){
    longPressActions(terms);
    closeCartButton.click();

}
public  Double getFormattedAmount(String amount){
    Double price= Double.parseDouble(amount.substring(1));
    return  price;

}
public void submitOrder(){
    checkBoxbutton.click();
    proceedButton.click();
}

}



