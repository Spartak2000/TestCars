package cars.pages.forms;

import cars.models.Car;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.ComboBox;
import org.openqa.selenium.By;

public class ComparisonsPage extends BasePage {
    private String locatorComparisons = "//h2[contains(text(),' Compare Cars Side-by-Side ')]";
    private String locatorForm = "//select[@id='%s-dropdown']";
    private ComboBox comboBoxCar;
    private String[] stringsValues = {"make", "model", "year"};
    private String locatorComparing = "//button[@class='done-button']";
    private Car car;
    private Button btnComparing = new Button(By.xpath(locatorComparing));

    public ComparisonsPage() {
        locatorPage = By.xpath(locatorComparisons);
        isOpen(locatorPage);
    }

    public void selectCar(int indexCar) {
        car = new Car();
        for (int i = 0; i < stringsValues.length; i++) {
            comboBoxCar = new ComboBox(String.format(locatorForm, stringsValues[i]));
            comboBoxCar.selectElement(Car.carList.get(indexCar - 1).getValues(stringsValues[i].concat("s")));
        }

    }

    public void navigateToComparing() {
        btnComparing.clickAndWait();
    }

}
