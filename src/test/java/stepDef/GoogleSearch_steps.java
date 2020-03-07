package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

public class GoogleSearch_steps {

    @Given("user goes to {string}")
    public void user_goes_to(String string) {
        Driver.getDriver().get(string);
    }

    @Then("user searches for {string}")
    public void user_searches_for(String string) {
        Driver.getDriver().findElement(By.name("q")).sendKeys(string + Keys.ENTER);
    }

    @Then("user verifies {string} in the page title")
    public void user_verifies_in_the_page_title(String string) {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains(string));
    }

}
