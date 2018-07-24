package cars.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.BaseElement;
import framework.BaseEntity;

import static cars.steps.FileSteps.softAssert;

public class BaseCucumber {
    @Before
    public void before() {
        BaseEntity.before();
    }

    @After
    public void after() {
        BaseEntity.after();
        softAssert.assertAll();
    }
}
