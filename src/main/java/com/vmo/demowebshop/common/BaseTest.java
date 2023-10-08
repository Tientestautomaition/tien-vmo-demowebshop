package com.vmo.demowebshop.common;

import com.vmo.demowebshop.Enviroment.LocalFactory;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.helper.TestNGListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

@Listeners(TestNGListener.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public WebDriver getBrowserDriver(@Optional("CHROME") String browser) {
            driver = new LocalFactory().createDriver(browser);
        Log.info("Open browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    protected void cleanBrowserAndDriver() {
        String cmd = "";
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            System.out.println("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            System.out.println("Driver instance name = " + osName);

            if (driverInstanceName.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstanceName.contains("internetexplorer")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driverInstanceName.contains("firefox")) {
                if (osName.contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstanceName.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            } else if (driverInstanceName.contains("opera")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
                } else {
                    cmd = "pkill operadriver";
                }
            } else if (driverInstanceName.contains("safari")) {
                if (osName.contains("mac")) {
                    cmd = "pkill safaridriver";
                }
            }
            //Browser
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Close browser and clean excutable driver:" + e.getMessage());
        } finally {
            try {
                //Excutable driver
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    protected int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
        Log.info("Close browser");
    }
}
