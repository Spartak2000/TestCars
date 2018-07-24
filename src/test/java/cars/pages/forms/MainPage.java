package cars.pages.forms;

import cars.pages.menus.MenuNavigate;
import framework.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private String locatorSpecial = "//h2[contains(text(),'Trending Searches')]";
    public MenuNavigate menuNavigate = new MenuNavigate();

    public MainPage() {
        locatorPage = By.xpath(locatorSpecial);
        isOpen(locatorPage);
    }

}
