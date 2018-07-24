package cars.pages.forms;

import cars.models.Car;
import cars.pages.menus.MenuNavigate;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ComparePage extends BasePage {
    private String locatorCompare = "//h1";
    private String locatorEngine = "//div[@class='cell cell-bg grow-2']";
    private String locatorTrans = "//div[@class='cell grow-2']";
    private String locatorHome = "//a[@data-linkname='header-home']";
    private Label lblEngine = new Label(By.xpath(locatorEngine));
    private Label lblTrans = new Label(By.xpath(locatorTrans));
    private Button btnHome = new Button(By.xpath(locatorHome));
    private String strEngine = "engine";
    private String strTrans = "trans";
    public MenuNavigate menuNavigate = new MenuNavigate();

    public ComparePage() {
        locatorPage = By.xpath(locatorCompare);
        isOpen(locatorPage);
    }

    /**
     * Add option on last car
     */
    public void addOptions() {
        Car.carList.get(Car.carList.size() - 1).setValue(strEngine, lblEngine.getText());
        Car.carList.get(Car.carList.size() - 1).setValue(strTrans, lblTrans.getText());
    }

    public void navigateToHome() {
        btnHome.click();
    }

}
