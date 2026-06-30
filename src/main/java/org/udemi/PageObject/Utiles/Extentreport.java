package org.udemi.PageObject.Utiles;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
    static ExtentReports extent;
   public static ExtentReports config() {

      ///ExtentReports  ExtantSparkReporter
  String path= System.getProperty("user.dir")+"/reports/index.html";
      ExtentSparkReporter reporter = new ExtentSparkReporter(path);
reporter.config().setDocumentTitle("Automation Report");
reporter.config().setReportName("Anastasiia Report");

      extent=new ExtentReports();
      extent.attachReporter(reporter);
      extent.setSystemInfo("tester","Anastasiia");
return extent;
   }
}
