package framework.elements;

import framework.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ComboBox extends BaseElement {
    private Select selectAim;

    public ComboBox(String locatorElement) {

        super(By.xpath(locatorElement));
    }

    public String selectRandomElement() {
        selectAim = new Select(getWebElement());
        Random random = new Random();
        int randomNumber = random.nextInt(selectAim.getOptions().size() - 1) + 1;
        selectAim.selectByIndex(randomNumber);
        return selectAim.getOptions().get(randomNumber).getText();
    }

    public void selectElement(String value) {
        selectAim = new Select(getWebElement());
        selectAim.selectByVisibleText(value);
    }
}

