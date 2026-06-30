package org.udemi.PageObject.Utiles;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumUtilsCommon {
    AppiumDriver driver;
    public AppiumDriverLocalService service;

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        // ✅ kill anything already on port 4723 before starting
        try {
            Runtime.getRuntime().exec("bash -c lsof -ti:4723 | xargs kill -9");
            Thread.sleep(1000);  // wait 1 second for port to free up
        } catch (Exception e) {
            System.out.println("No existing Appium process found");
        }

//System.getProperty("user:dir",jsonFilePath)+"/src/main/java/org/udemi/PageObject/Utiles/AppiumUtilsCommon.java"
        // Step 1 — read the JSON file into a String
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath));


        // Step 2 — parse JSON string into List of HashMaps
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {  // tells Jackson the type
                });


        return data;
    }
    public AppiumDriverLocalService startServer(String ipAdress, int port){
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload")
                .withIPAddress(ipAdress)
                .usingPort(port)
                .build();
        service.start();
        return service;
    }

    public  Double getFormattedAmount(String amount){
        Double price= Double.parseDouble(amount.substring(1));
        return  price;

    }


    public void waitforElementToAppear(WebElement ele){
        WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitCart.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
    }
public String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException {
File screenShot=driver.getScreenshotAs(OutputType.FILE);
String destinationFile= System.getProperty("user.dir")+"/reports/screenshots/"+testCaseName +".png";
FileUtils.copyFile(screenShot, new File(destinationFile));
return "screenshots/" + testCaseName + ".png";
    }
}
