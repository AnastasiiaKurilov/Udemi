package org.Base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.AppleTests.Apple.HomePage;
import org.udemi.PageObject.Utiles.AppiumUtilsCommon;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseTestsIOS extends AppiumUtilsCommon {
   public IOSDriver driver;
    public AppiumDriverLocalService service;
    public HomePage homePage;
    @BeforeClass(alwaysRun = true)

    public void ConfigurationAppium() throws IOException {

        /// code to start Server
        FileInputStream file= new FileInputStream(
                System.getProperty("user.dir")+"/src/test/resources/data.properties");
        Properties prop= new Properties();
        prop.load(file);
        String ipAdress= prop.getProperty("ipAdress");
        String port= prop.getProperty("port");

       service =startServer( ipAdress,Integer.parseInt(port));

        /// IOSDriver
XCUITestOptions options = new XCUITestOptions();
options.setAutomationName("XCUITest");
options.setDeviceName(prop.getProperty("IOSDevice"));
//options.setDeviceName("iPhone 16");//simulator
options.setPlatformVersion("18.3");
    //    options.setDeviceName("iPhone (73)");//real device
    //    options.setUdid("00008120-001A78460240201E");
    //    options.setPlatformVersion("26.3.1");
options.setApp("/Users/anastasiakurilova/Library/Developer/Xcode/DerivedData/UIKitCatalog-gkigmtkwkezuaxbbphkziqovhihp/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
       // options.setApp("/Users/anastasiakurilova/IdeaProjects/AnnaAppium/src/test/resources/TestApp 3.app");
/// Appium- Webdriver Agent->IOS app
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        /// set up driver
     driver = new IOSDriver(service.getUrl(),options);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10 ));
     homePage= new HomePage(driver);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        ///code stop server
        driver.quit();
        service.stop();

    }

}
