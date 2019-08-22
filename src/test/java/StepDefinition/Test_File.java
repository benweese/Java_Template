package StepDefinition;

import cucumber.api.PendingException;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


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
