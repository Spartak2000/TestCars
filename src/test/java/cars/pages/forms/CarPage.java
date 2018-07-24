package cars.pages.forms;

import cars.models.Car;
import cars.steps.FileSteps;
import framework.BaseElement;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CarPage extends BasePage {
    private String locatorSpecial = "//h1";
    private String locatorCompare = "//a[contains(text(),'Compare Trims')]";
    private Button btnCompare = new Button(By.xpath(locatorCompare));
    private ResearchPage researchPage;

    public CarPage() {
        locatorPage = By.xpath(locatorSpecial);
        isOpen(locatorPage);
    }

    public boolean checkCar() {
        return btnCompare.isDisplayed();
    }

    public void navigateToCompare() {
        btnCompare.clickAndWait();
    }

    public void checkButtonAndClick() {
        for (int i = 0; i < Integer.parseInt(configReader.getProperties("countToTry")); i++) {
            if (!checkCar()) {
                Car.carList.remove(Car.carList.size() - 1);
                BasePage.goToBack();
                researchPage = new ResearchPage();
                researchPage.selectCar();
                researchPage.navigateToSearch();
            } else {
                navigateToCompare();
                break;
            }
        }
    }
}

