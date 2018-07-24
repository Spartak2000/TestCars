package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class BaseElement extends BaseEntity {

    private By uniqueLocatorElement;
    private String strTimeout = "timeout";
    protected WebElement webElement;
    private By locator;

    protected BaseElement(By locatorElement) {
        locator = locatorElement;
    }

    public WebElement getWebElement() {
        return driver.findElement(locator);
    }

    public void click() {
        webElement = driver.findElement(locator);
        webElement.isEnabled();
        webElement.click();
    }

    public void clickAndWait() {
        driver.findElement(locator).click();
        new WebDriverWait(driver, Integer.parseInt(configReader.getProperties("timeout"))).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));


    }

    public void waitAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(configReader.getProperties("timeout")));
        webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        webElement.click();

    }

    public String getText() {
        webElement = driver.findElement(locator);
        webElement.isEnabled();
        return webElement.getText();
    }

    public void moveTo() {
        webElement = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(this.webElement).build().perform();
    }

    public static List<WebElement> getCollection(String locatorSpecial) {

        List<WebElement> webElementList = driver.findElements(By.xpath(locatorSpecial));
        return webElementList;
    }

    public boolean isDisplayed() {
        try {
            driver.findElement(locator).isDisplayed();
        } catch (Throwable t) {
            return false;
        }
        return true;
    }
}