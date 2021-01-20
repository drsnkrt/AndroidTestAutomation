package main.cv;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import org.apache.tools.ant.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CroApp {

    public AndroidDriver driver;
    public WebDriverWait wait;
    ExtentReports extent;
    String date;

    @BeforeMethod
    public void setup() {
        try {
            date = new SimpleDateFormat("hhmmss").format(new Date());
            extent = new ExtentReports();
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appActivity", "hr.miz.evidencijakontakata.Activities.SplashActivity");
            caps.setCapability("appPackage", "hr.miz.evidencijakontakata");
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("deviceName", "Nexus6");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "11.0");
            caps.setCapability("skipUnlock", "true");
            caps.setCapability("noReset", "false");
            caps.setCapability("app", "D:\\TP\\cro.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            wait = new WebDriverWait(driver, 60);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void goMainPage() {
        try {
            Thread.sleep(3000);
            if (driver.findElementById("hr.miz.evidencijakontakata:id/tvLanguage").getAttribute("text").contains("Jezik aplikacije:") == true) {
                driver.findElementById("hr.miz.evidencijakontakata:id/rlEnglish").click();
                Thread.sleep(2000);
                driver.findElementById("hr.miz.evidencijakontakata:id/llStart").click();
                Thread.sleep(2000);
                driver.findElementById("hr.miz.evidencijakontakata:id/btnProceed").click();
                Thread.sleep(2000);
                driver.findElementById("hr.miz.evidencijakontakata:id/switchOnOff").click();
                Thread.sleep(2000);
                driver.findElementById("android:id/button1").click();
                Thread.sleep(2000);
                Assert.assertTrue("Test Başarılı", driver.findElementById("hr.miz.evidencijakontakata:id/tvExposure").getAttribute("text").contains("Stop COVID-19"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getScreenShot(WebDriver driver, String imageName) {
        String destination = "";
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            destination = "D:\\TP\\screens2\\" + imageName + ".png";
            File finalDestination = new File(destination);

            FileUtils.getFileUtils().copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
        extent.flush();
    }

}
