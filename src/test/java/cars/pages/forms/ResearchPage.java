package cars.pages.forms;

import cars.models.Car;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.ComboBox;
import org.openqa.selenium.By;


public class ResearchPage extends BasePage {
    private String locatorResearch = "//h2[contains(text(),'Research Car Models')]";
    private String locatorForm = "//div[@class='hsw-%s']//select";
    private String locatorSearch = "//input[@value]";
    private String locatorSideBySide = "//h4[contains(text(),'Side-by-side Comparisons')]";
    private ComboBox comboBoxCar;
    private Car car;
    private String[] stringsValue = {"makes", "models", "years"};
    private Button btnSearch = new Button(By.xpath(locatorSearch));
    private Button btnSideBySide = new Button(By.xpath(locatorSideBySide));

    public ResearchPage() {
        locatorPage = By.xpath(locatorResearch);
        isOpen(locatorPage);
    }

    public void selectCar() {
        car = new Car();
        for (int i = 0; i < stringsValue.length; i++) {
            comboBoxCar = new ComboBox(String.format(locatorForm, stringsValue[i]));
            car.setValue(stringsValue[i], comboBoxCar.selectRandomElement());
        }
        car.addCarToList();
    }

    public void navigateToSearch() {
        btnSearch.click();
    }

    public void navigateToSideBySide() {
        btnSideBySide.click();
    }

}
