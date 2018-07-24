package framework;

import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;


public abstract class BasePage extends BaseEntity {
    protected By locatorPage;

    protected void isOpen(By locator) {
        Assert.assertTrue(driver.findElement(locator).isEnabled());
    }

    public static void goToBack() {
        driver.navigate().back();
    }

}

