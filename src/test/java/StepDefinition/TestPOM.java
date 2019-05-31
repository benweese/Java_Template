package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPOM {
    WebDriver driver;

    By classN = By.className("item");
    By IDN = By.id("item");
    By nameN = By.name("item");
    By xpathN = By.xpath("item");



    public TestPOM(WebDriver driver){
        this.driver = driver;
    }



}
