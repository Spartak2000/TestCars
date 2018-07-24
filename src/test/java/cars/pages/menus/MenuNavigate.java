package cars.pages.menus;

import framework.elements.Label;
import org.openqa.selenium.By;

public class MenuNavigate {

    private String locatorMenu = "//div[@style]/../ul//a[@title='Specifications and reviews on car models']";
    private Label lblMenu;

    public enum MainMenu {
        Research("Research"),
        ServiceAndRepair("Service & Repair");

        private String partLocator;

        MainMenu(String str) {
            this.partLocator = str;
        }

    }

    public void setElement(MainMenu mainMenu) {
        lblMenu = new Label(By.xpath(String.format(locatorMenu, mainMenu.partLocator)));
        lblMenu.click();
    }


}