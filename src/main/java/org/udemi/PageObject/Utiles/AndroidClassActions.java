package org.udemi.PageObject.Utiles;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


public class AndroidClassActions extends AppiumUtilsCommon{
    AndroidDriver driver;

    public AndroidClassActions(AndroidDriver driver) {
      //  super(driver);
        this.driver = driver;
    }

    public void longPressActions(WebElement peopleName) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) peopleName).getId(),
                        "duration", 2000));
    }

    public void scrollUntilEnd() {                          // ✅ fixed naming
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "mobile: scrollGesture", ImmutableMap.of(
                            "left", 100, "top", 100, "width", 200, "height", 200,
                            "direction", "down",
                            "percent", 1.0
                    ));
        } while (canScrollMore);
    }

    public void scrollToText(String text) {                 // ✅ already correct
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void swipeOnOne(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.15
        ));
    }

    public Double getFormattedAmount(String amount) {       // ✅ fixed typo
        return Double.parseDouble(amount.substring(1));
    }
}