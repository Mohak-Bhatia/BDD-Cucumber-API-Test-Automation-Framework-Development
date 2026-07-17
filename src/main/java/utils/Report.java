// File: src/main/java/utils/Report.java

package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import propertiesFetcher.ConfigReader;

public class Report {
    
    public static ExtentReports TestReport() {
        // Get report path from ConfigReader (can be overridden by environment variable)
        String reportPath = ConfigReader.getProperty("report.path");
        String reportTitle = ConfigReader.getProperty("extent.report.title");
        String reportAuthor = ConfigReader.getProperty("extent.report.author");
        
        String path = System.getProperty("user.dir") + "/" + reportPath + "index.html";
        
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle(reportTitle);
        reporter.config().setReportName("BDD API Test Execution Report");
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Test Engineer", reportAuthor);
        extent.setSystemInfo("Environment", ConfigReader.getProperty("base.uri"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        
        return extent;
    }
}