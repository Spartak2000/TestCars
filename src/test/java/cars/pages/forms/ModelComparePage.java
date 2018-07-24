package cars.pages.forms;

import cars.models.Car;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelComparePage extends BasePage {

    private String locatorSpecial = "//h1";
    private String locatorAddCar = "//div[@class='add-car-icon']";
    private String[] stringsValues = {"make", "model", "year"};
    private String stringsLocator = "//select[@id='%s-dropdown']";
    private String locatorDone = "//button[@class='modal-button']";
    public static String[] stringsName = {"", ""};
    private String locatorCarName = "//span[@index=0 and @class='info-data col-three-cars']//h4";
    private String locatorCarNameForCompare = "//span[@index=1 and @class='info-data col-three-cars']//h4";
    private Button btnAddCar = new Button(By.xpath(locatorAddCar));
    private Button btnNavigate = new Button(By.xpath(locatorDone));
    private String locatorCarEngine = "//cars-compare-compare-info[@header='Engine']//span[@index=0]";
    private String locatorCarEngineForCompare = "//cars-compare-compare-info[@header='Engine']//span[@index=1]";
    private String locatorCarTrans = "//cars-compare-compare-info[@header='Transmission']//span[@index=0]";
    private String locatorCarTransForCompare = "//cars-compare-compare-info[@header='Transmission']//span[@index=1]";
    private ComboBox comboBoxCar;
    private String[] values = {"engine", "trans"};
    private Label lblNameCar = new Label(By.xpath(locatorCarName));
    private Label lblNameCarForCompare = new Label(By.xpath(locatorCarNameForCompare));
    private Label lblEngineCar = new Label(By.xpath(locatorCarEngine));
    private Label lblEngineCarForCompare = new Label(By.xpath(locatorCarEngineForCompare));
    private Label lblTransCar = new Label(By.xpath(locatorCarTrans));
    private Label lblTransCarForCompare = new Label(By.xpath(locatorCarTransForCompare));
    private String strYears = "years";
    private String strModels = "models";
    private String strMakes = "makes";
    private String endChar = ",";
    private String[] subStr;


    public ModelComparePage() {
        locatorPage = By.xpath(locatorSpecial);
        isOpen(locatorPage);
    }

    public void clickToAddCar() {
        btnAddCar.waitAndClick();
    }

    public boolean equalsCar() {
        int count = 0;
        for (int i = 0; i < Car.carList.size(); i++) {
            if (ModelComparePage.stringsName[i].equals(Car.carList.get(i).getValues(strYears).concat(" ").concat(Car.carList.get(i).getValues(strMakes).concat(" ").concat(Car.carList.get(i).getValues(strModels)))))
                count++;
        }
        return count == Car.carList.size();
    }

    public void selectCar(int indexCar) {
        for (String stringsValue : stringsValues) {
            comboBoxCar = new ComboBox(String.format(stringsLocator, stringsValue));
            comboBoxCar.selectElement(Car.carList.get(indexCar - 1).getValues(stringsValue.concat("s")));
        }
    }

    private String[] deleteChar(){
        for (int numberStr = 0; numberStr < subStr.length; numberStr++) {
            if (subStr[numberStr].endsWith(endChar)) {
                subStr[numberStr] = subStr[numberStr].substring(0, subStr[numberStr].length() - 1);
            }
        }
        return  subStr;
    }

    public void navigateToCompare() {

        btnNavigate.click();
        stringsName[0] = lblNameCar.getText();
        stringsName[1] = lblNameCarForCompare.getText();
    }

    /**
     * Method for to check car. Crop the array of rows by "," and compare these values ​​with the fields of car
     */
    public boolean checkCar() {
        int numberCoincidences = 0;
        String regEx = "\n";
        String[] stringsValue = {lblEngineCar.getText(), lblEngineCarForCompare.getText(), lblTransCar.getText(), lblTransCarForCompare.getText()};
        for (String aStringsValue : stringsValue) {
            subStr = aStringsValue.split(regEx);
            subStr=deleteChar();
            for (int i = 0; i < Car.carList.size(); i++) {
                for (String value : values)
                    if (Arrays.asList(subStr).contains(Car.carList.get(i).getValues(value)))
                        numberCoincidences++;
            }
        }
        return numberCoincidences >= stringsValue.length;
    }
}
