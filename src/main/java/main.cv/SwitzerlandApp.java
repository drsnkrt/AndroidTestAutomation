package main.cv;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import org.apache.tools.ant.util.FileUtils;
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

public class SwitzerlandApp {

    public AndroidDriver driver;
    public WebDriverWait wait;
    ExtentReports extent;
    ExtentSparkReporter spark;
    ExtentTest test;
    String date;

    @BeforeMethod
    public void setup() {
        try {
            date = new SimpleDateFormat("hhmmss").format(new Date());
            extent = new ExtentReports();
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appActivity", "ch.admin.bag.dp3t.MainActivity");
            caps.setCapability("appPackage", "ch.admin.bag.dp3t");
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("deviceName", "Nexus6");
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "11.0");
            caps.setCapability("skipUnlock", "true");
            caps.setCapability("noReset", "false");
            caps.setCapability("app", "D:\\TP\\SwissCovid_v1.2.1_apkpure.com.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            wait = new WebDriverWait(driver, 60);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void checkSplashScreen() {
        spark = new ExtentSparkReporter("D:\\TP\\reports\\checkSplashScreen.html");
        extent.attachReporter(spark);
        try {
            test = extent.createTest("checkSplashScreen");
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "checkSplashScreen");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
                test.pass("Splash Screen is visible and Apk is working...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkSplashScreen"})
    public void checkFirstContinueButton() {
        spark = new ExtentSparkReporter("D:\\TP\\reports\\clickFirstContinueButton.html");
        extent.attachReporter(spark);
        try {
            test = extent.createTest("clickFirstContinueButton");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFirstContinueButton.png").build());
                test.pass("First Continue Button visible...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test(dependsOnMethods = {"checkFirstContinueButton"})
    public void checkSecondContinueButton() {
        spark = new ExtentSparkReporter("D:\\TP\\reports\\clickSecondContinueButton.html");
        extent.attachReporter(spark);
        try {
            test = extent.createTest("clickSecondContinueButton");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFirstContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button visible...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkSecondContinueButton"})
    public void checkThirdContinueButton() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\clickThirdContinueButton.html");
            extent.attachReporter(spark);
            test = extent.createTest("clickThirdContinueButton");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFirstContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button visible...");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkThirdContinueButton"})
    public void checkFourthContinueButton() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\clickFourthContinueButton.html");
            extent.attachReporter(spark);
            date = new SimpleDateFormat("hhmmss").format(new Date());
            test = extent.createTest("clickFourthContinueButton");
            Thread.sleep(3000);
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Report of potential infection") == true) {
                getScreenShot(driver, "clickFourthContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFourthContinueButton.png").build());
                test.pass("Fourth Continue Button visible...");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkFourthContinueButton"})
    public void checkAcceptButton() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\clickAcceptButton.html");
            extent.attachReporter(spark);
            date = new SimpleDateFormat("hhmmss").format(new Date());
            test = extent.createTest("clickAcceptButton");
            Thread.sleep(3000);
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Report of potential infection") == true) {
                getScreenShot(driver, "clickFourthContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFourthContinueButton.png").build());
                test.pass("Fourth Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Accept") == true) {
                getScreenShot(driver, "acceptButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\acceptButton.png").build());
                test.pass("Accept Button is visible...");
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkAcceptButton"})
    public void checkContinueButton() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\checkContinueButton.html");
            extent.attachReporter(spark);
            date = new SimpleDateFormat("hhmmss").format(new Date());
            test = extent.createTest("checkContinueButton");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);

            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Report of potential infection") == true) {
                getScreenShot(driver, "clickFourthContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFourthContinueButton.png").build());
                test.pass("Fourth Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Accept") == true) {
                getScreenShot(driver, "acceptButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\acceptButton.png").build());
                test.pass("Accept Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").getAttribute("text").contains("Continue") == true) {
                getScreenShot(driver, "continueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\continueButton.png").build());
                test.pass("Continue Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").click();
                Thread.sleep(1000);
            } else {
                getScreenShot(driver, "allowButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\allowButton.png").build());
                test.pass("Allow Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_button").click();
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkContinueButton"})
    public void checkActivateButton() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\checkActivateButton.html");
            extent.attachReporter(spark);
            date = new SimpleDateFormat("hhmmss").format(new Date());
            test = extent.createTest("checkActivateButton");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);

            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Report of potential infection") == true) {
                getScreenShot(driver, "clickFourthContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFourthContinueButton.png").build());
                test.pass("Fourth Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Accept") == true) {
                getScreenShot(driver, "acceptButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\acceptButton.png").build());
                test.pass("Accept Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").getAttribute("text").contains("Continue") == true) {
                getScreenShot(driver, "continueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\continueButton.png").build());
                test.pass("Continue Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").click();
                Thread.sleep(1000);
            } else {
                getScreenShot(driver, "allowButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\allowButton.png").build());
                test.pass("Allow Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").getAttribute("text").contains("Activate") == true) {
                getScreenShot(driver, "activateButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\activateButton.png").build());
                test.pass("Activate Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").click();
                Thread.sleep(1000);
                getScreenShot(driver, "okButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\okButton.png").build());
                test.pass("Ok Button is visible...");
                driver.findElementById("android:id/button1").click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkActivateButton"})
    public void checkTurnOnButton() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\checkTurnOnButton.html");
            extent.attachReporter(spark);
            date = new SimpleDateFormat("hhmmss").format(new Date());
            test = extent.createTest("checkTurnOnButton");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);

            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Report of potential infection") == true) {
                getScreenShot(driver, "clickFourthContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFourthContinueButton.png").build());
                test.pass("Fourth Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Accept") == true) {
                getScreenShot(driver, "acceptButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\acceptButton.png").build());
                test.pass("Accept Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").getAttribute("text").contains("Continue") == true) {
                getScreenShot(driver, "continueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\continueButton.png").build());
                test.pass("Continue Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").click();
                Thread.sleep(1000);
            } else {
                getScreenShot(driver, "allowButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\allowButton.png").build());
                test.pass("Allow Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").getAttribute("text").contains("Activate") == true) {
                getScreenShot(driver, "activateButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\activateButton.png").build());
                test.pass("Activate Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").click();
                Thread.sleep(2000);
            }
            if (driver.findElementById("android:id/button1").getAttribute("text").contains("Turn on") == true) {
                getScreenShot(driver, "turnOnButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\turnOnButton.png").build());
                test.pass("Turn on Button is visible...");
                driver.findElementById("android:id/button1").click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkTurnOnButton"})
    public void checkStartButton() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\checkStartButton.html");
            extent.attachReporter(spark);
            date = new SimpleDateFormat("hhmmss").format(new Date());
            test = extent.createTest("checkStartButton");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);

            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Report of potential infection") == true) {
                getScreenShot(driver, "clickFourthContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFourthContinueButton.png").build());
                test.pass("Fourth Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Accept") == true) {
                getScreenShot(driver, "acceptButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\acceptButton.png").build());
                test.pass("Accept Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").getAttribute("text").contains("Continue") == true) {
                getScreenShot(driver, "continueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\continueButton.png").build());
                test.pass("Continue Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").click();
                Thread.sleep(1000);
            } else {
                getScreenShot(driver, "allowButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\allowButton.png").build());
                test.pass("Allow Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").getAttribute("text").contains("Activate") == true) {
                getScreenShot(driver, "activateButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\activateButton.png").build());
                test.pass("Activate Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("android:id/button1").getAttribute("text").contains("Turn on") == true) {
                getScreenShot(driver, "turnOnButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\turnOnButton.png").build());
                test.pass("Turn on Button is visible...");
                driver.findElementById("android:id/button1").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Start") == true) {
                getScreenShot(driver, "StartButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\StartButton.png").build());
                test.pass("Start Button is visible...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"checkStartButton"})
    public void goMainPage() {
        try {
            spark = new ExtentSparkReporter("D:\\TP\\reports\\goMainPage.html");
            extent.attachReporter(spark);
            date = new SimpleDateFormat("hhmmss").format(new Date());
            test = extent.createTest("goMainPage");
            getScreenShot(driver, "checkSplashScreen");
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\checkSplashScreen.png").build());
            test.pass("Splash Screen is visible and Apk is working...");
            Thread.sleep(3000);

            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Staying one step ahead of the virus") == true) {
                getScreenShot(driver, "clickFirstContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("First Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Protection of privacy") == true) {
                getScreenShot(driver, "clickSecondContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickSecondContinueButton.png").build());
                test.pass("Second Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Recognising encounters using Bluetooth") == true) {
                getScreenShot(driver, "clickThirdContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickThirdContinueButton.png").build());
                test.pass("Third Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_title").getAttribute("text").contains("Report of potential infection") == true) {
                getScreenShot(driver, "clickFourthContinueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\clickFourthContinueButton.png").build());
                test.pass("Fourth Continue Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Accept") == true) {
                getScreenShot(driver, "acceptButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\acceptButton.png").build());
                test.pass("Accept Button clicked...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").getAttribute("text").contains("Continue") == true) {
                getScreenShot(driver, "continueButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\continueButton.png").build());
                test.pass("Continue Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_continue_button").click();
                Thread.sleep(1000);
            } else {
                getScreenShot(driver, "allowButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\allowButton.png").build());
                test.pass("Allow Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_battery_permission_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").getAttribute("text").contains("Activate") == true) {
                getScreenShot(driver, "activateButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\activateButton.png").build());
                test.pass("Activate Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_gaen_button").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("android:id/button1").getAttribute("text").contains("Turn on") == true) {
                getScreenShot(driver, "turnOnButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\turnOnButton.png").build());
                test.pass("Turn on Button is visible...");
                driver.findElementById("android:id/button1").click();
                Thread.sleep(1000);
            }
            if (driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").getAttribute("text").contains("Start") == true) {
                getScreenShot(driver, "StartButton");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\StartButton.png").build());
                test.pass("Start Button is visible...");
                driver.findElementById("ch.admin.bag.dp3t:id/onboarding_continue_button").click();
                Thread.sleep(2000);
                getScreenShot(driver, "mainPage");
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath("D:\\TP\\screens\\mainPage.png").build());
                test.pass("Main Page is visible...");
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
            destination = "D:\\TP\\screens\\" + imageName + ".png";
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
