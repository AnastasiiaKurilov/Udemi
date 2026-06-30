package org.AndroidTests;

import io.appium.java_client.AppiumBy;
import org.Base.BaseTestsAndroid;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/// Test case in Filling the form details for shopping
public class TestCaseFillingFormFromCard extends BaseTestsAndroid {


    @Test
    public void fill_formNegative() {

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

        driver.findElement(By.id("android:id/text1")).click();

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"
        ));

        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String toast = driver.findElement(By.xpath("//android.widget.Toast[1]"))
                .getAttribute("name");

        Assert.assertEquals(toast, "Please  your name");
    }


    @Test
    public void fill_formPositive() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anastasiia Marquis");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"
        ));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//android.widget.Toast[1]")).size() < 1, "Toast should not be visible");

    }
}

