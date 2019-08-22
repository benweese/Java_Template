package StepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class Test_File {

    private WebDriver driver;
    private TestPOM testPOM;
    private String url;
    private Setup setup = new setup();


    @Before
    public void beforeSenario(){
        setup.setDriver();
        driver = setup.getDriver();
        testPOM  = new TestPOM(driver);
        setup.setUrl("Something");
        url = setup.getUrl();
        driver.get(url);
    }

    @Given("^statement$")
    public void statement() {

        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @When("^statement (\\d+)$")
    public void statement(int arg) {

       //throw PendingException;


    }

    @Then("^statement$")
    public void statement2() {

        Assert.assertEquals(url, driver.getCurrentUrl());
        driver.quit();
    }
}
