package cars.steps;

import cars.models.Car;
import cars.pages.forms.*;
import cars.pages.menus.MenuNavigate;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BasePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSteps {

    private MainPage mainPage;
    private ResearchPage researchPage;
    private CarPage carPage;
    private ComparePage comparePage;
    private ComparisonsPage comparisonsPage;
    private ModelComparePage modelComparePage;
    public static SoftAssert softAssert;


    @Given("^User on a main page$")
    public void goUserOnMainPage() {

        softAssert = new SoftAssert();
        mainPage = new MainPage();
    }

    @When("^User go to \"([^\"]*)\"$")
    public void goToElement(String menuElement) {
        mainPage.menuNavigate.setElement(MenuNavigate.MainMenu.valueOf(menuElement));
    }

    @Then("^The page Research is opened$")
    public void openThePageResearch() {
        researchPage = new ResearchPage();
    }

    @When("^User select random values for a car and click search$")
    public void selectRandomValuesForACarAndClickSearch() {
        researchPage.selectCar();
        researchPage.navigateToSearch();
    }

    @Then("^The page car is opened$")
    public void openThePageCar() {
        carPage = new CarPage();
    }

    @When("^User click button Compare$")
    public void clickButtonCompare() {
        carPage.checkButtonAndClick();
    }

    @Then("^The page compare is opened$")
    public void openThePageCompare() {
        comparePage = new ComparePage();
    }

    @When("^User save new options$")
    public void saveNewOptions() {
        comparePage.addOptions();
    }

    @And("^User go to main page$")
    public void goToMainPage() {
        comparePage.navigateToHome();
    }

    @Then("^Main page is opened$")
    public void openThePageMain() {
        goUserOnMainPage();
    }

    @When("^User click a button Side-by-Side$")
    public void clickAButtonSideBySide() {
        researchPage.navigateToSideBySide();
    }

    @Then("^The page Side-by-Side is opened$")
    public void openThePageComparisons() {
        comparisonsPage = new ComparisonsPage();
    }

    @When("^User select values$")
    public void selectValues() {
        comparisonsPage.selectCar(1);
    }

    @And("^Click a button$")
    public void clickAButtonComparing() {
        comparisonsPage.navigateToComparing();
    }

    @Then("^The page model compare is opened$")
    public void openThePageModelComparing() {
        modelComparePage = new ModelComparePage();
    }

    @When("^User click add car$")
    public void clickAddCar() {
        modelComparePage.clickToAddCar();
    }

    @And("^Select value$")
    public void selectValue() {
        modelComparePage.selectCar(2);
    }

    @And("^Click button done$")
    public void clickButtonDone() {
        modelComparePage.navigateToCompare();
        softAssert.assertTrue(modelComparePage.equalsCar());
    }

    @Then("^The necessary cars were opened$")
    public void openTheNecessaryCar() {
        softAssert.assertTrue(modelComparePage.checkCar());
    }
}
