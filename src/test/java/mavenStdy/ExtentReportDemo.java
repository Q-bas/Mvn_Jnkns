package mavenStdy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportDemo {

    ExtentReports extent;

    @BeforeTest
    private void config() {
        
        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("web automation results");
        reporter.config().setDocumentTitle("Test Results");
        
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("env", "QA");
    }

    @Test
    public void initialDemo() {

        ExtentTest test = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver","/Users/andrew/dev0/files/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.getTitle());
        test.fail("NONONONO");

        extent.flush();
    }
    
    
}
