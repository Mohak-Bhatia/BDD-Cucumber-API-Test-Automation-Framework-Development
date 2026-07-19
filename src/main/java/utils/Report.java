package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
    
    public static ExtentReports TestReport() {
        
        String reportPath = System.getenv("REPORT_PATH");
        String reportTitle = System.getenv("REPORT_TITLE");
        String reportAuthor = System.getenv("REPORT_AUTHOR");
        
        String path = System.getProperty("user.dir") + "/" + reportPath + "index.html";
        
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle(reportTitle);
        reporter.config().setReportName("BDD API Test Execution Report");
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Test Engineer", reportAuthor);
        extent.setSystemInfo("Environment", System.getenv("BASE_URI"));
        
        return extent;
    }
}