package org.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.AndroidTests.Android.FormPage;
import org.udemi.PageObject.Utiles.AppiumUtilsCommon;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseTestsAndroid extends AppiumUtilsCommon {
   public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public FormPage form_page;


    @BeforeClass(alwaysRun = true)

    public void ConfigurationAppium() throws IOException {

        /// code to start Server

        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir")+"/src/test/resources/data.properties");
        Properties prop= new Properties();
        prop.load(file);
        String ipAdress= System.getProperty("ipAdress")!=null?System.getProperty("ipAdress"):prop.getProperty("ipAdress");
      // String ipAdress= prop.getProperty("ipAdress");
        String port= prop.getProperty("port");

        service =startServer(ipAdress,Integer.parseInt(port));


        /// AndroidDriver, IOSDriver
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformName(prop.getProperty("AndroidDevice"));
        //options.setDeviceName("Pixel9Anna");
        //options.setChromedriverExecutable("");
        //options.setChromedriverExecutable("/Users/anastasiakurilova/Drivers/chromedriver_144");
        options.setApp("/Users/anastasiakurilova/IdeaProjects/AppiumUdemi/src/test/resources/General-Store.apk");
        //options.setPlatformVersion("16.0");
       driver = new AndroidDriver(service.getUrl(),options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10 ));
       form_page=new FormPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        ///code stop server
        driver.quit();
        service.stop();

    }

}
