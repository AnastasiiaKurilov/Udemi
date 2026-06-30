package org.udemi.PageObject.Utiles;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;


public class IOSClassActions extends AppiumUtilsCommon{
IOSDriver driver;

    public IOSClassActions(IOSDriver driver) {
     //   super(driver);
        this.driver = driver;
    }

    public void longPressActions(WebElement ele) {
        Map<String,Object> params= new HashMap<>();
        params.put("elementId",((RemoteWebElement)ele).getId());
        params.put("duration",5);
        driver.executeScript("mobile: touchAndHold",params);
    }

    public void scrollUntilEnd() {
        // iOS mobile: scroll does NOT return a boolean like Android's scrollGesture.
        // So we scroll a fixed number of times instead of checking a return value.
        // Adjust maxScrolls based on how long your list can be.
        int maxScrolls = 10;
        for (int i = 0; i < maxScrolls; i++) {
            Map<String, Object> params = new HashMap<>();
            params.put("direction", "down");
            params.put("velocity", 500);  // pixels per second — lower = slower scroll
            driver.executeScript("mobile: scroll", params);
        }
    }

    // Option 1: mobile: scroll with predicateString (recommended)
// Scrolls AND finds the element in one call — cleanest iOS approach
    public void scrollTowebElement(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("predicateString", "label == '" +ele + "'");
        driver.executeScript("mobile: scroll", params);
    }

public void swipeActions(WebElement ele, String direction){
    Map<String, Object> param1 = new HashMap<String, Object>();
    param1.put("direction", "left");
    driver.executeScript("mobile:swipe", param1);
}

    public Double getFormattedAmount(String amount) {       // ✅ fixed typo
        return Double.parseDouble(amount.substring(1));
    }
}
