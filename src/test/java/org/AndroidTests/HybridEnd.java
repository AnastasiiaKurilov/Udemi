package org.AndroidTests;

import org.Base.BaseTestsAndroid;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.AndroidTests.Android.CartPage;
import org.AndroidTests.Android.productCatalogue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


/// Test case in Filling the form details for shopping
public class HybridEnd extends BaseTestsAndroid {
    @BeforeMethod(alwaysRun = true)
    public void presetUp() {
        // 1️Terminate app to start fresh
     form_page.setActivity();
    }
    @Test(dataProvider = "getdata",groups = {"Smoke"})
    public void shopmultiple(HashMap<String,String>input) throws InterruptedException {

        form_page.setNameField(input.get("name"));
        form_page.setGender(input.get("gender"));
        form_page.setCountrySelection(input.get("country"));

        productCatalogue product_catalogue=form_page.setLetsGoButton();
        product_catalogue.addItemToCartByIndex(0);
        product_catalogue.addItemToCartByIndex(0);
        CartPage cart_page= product_catalogue.setCartbutton();
//WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(5));
// waitCart.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));

        double totalSum= cart_page.getproductSum();
        double displayedSum = cart_page.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum,displayedSum);

        cart_page.acceeptTermsConditions();
        cart_page.submitOrder();


}
@DataProvider
    public Object[][] getdata() throws IOException {

      List<HashMap<String,String>>data= getJsonData(System.getProperty("user.dir")+"/src/main/java/org/udemi/PageObject/Data/LoginPageCredentials.json");
      return new Object[][]{
              {data.get(0)},
              {data.get(1)},
              {data.get(2)},
      };

    }
}

