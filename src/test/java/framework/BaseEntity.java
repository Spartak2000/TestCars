package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseEntity {

    private static final String strUrl = "url";
    private static final String strTimeOut = "timeout";
    protected static ConfigReader configReader;
    protected static WebDriver driver;

    @BeforeClass
    public static void before() {
        configReader = new ConfigReader("config");
        driver = BrowserFactory.getSingletonBrowser();
        driver.get(configReader.getProperties(strUrl));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(configReader.getProperties(strTimeOut)), TimeUnit.SECONDS);
    }

    @AfterClass
    public static void after() {
        driver.quit();
    }


}
