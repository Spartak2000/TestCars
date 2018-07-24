package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BrowserFactory extends BaseEntity {

    private static String OS = System.getProperty("os.name").toLowerCase().substring(0, 4);
    private static final String strBrowser = "browser";
    private static String pathChrome = "./src/test/resources/drivers/chromedriver";
    private static String pathFirefox = "./src/test/resources/drivers/geckodriver";

    private BrowserFactory() {
    }


    public static WebDriver getSingletonBrowser() {
          String strBrowser=System.getProperty("browser");
        if(strBrowser==null)
            strBrowser=configReader.getProperties("browser");
        if (driver == null) {
            switch (OS) {
                case "wind": {
                    pathChrome += ".exe";
                    pathFirefox += ".exe";
                }
            }
            switch (strBrowser) {
                case "Chrome": {
                    try {
                        System.setProperty("webdriver.chrome.driver", new File(pathChrome).getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return driver = new ChromeDriver();
                }
                case "Firefox": {
                    try {
                        System.setProperty("webdriver.gecko.driver", new File(pathFirefox).getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        return driver = new FirefoxDriver();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return driver;
    }
}
