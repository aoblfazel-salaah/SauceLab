package Steps;

import Utility.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebsiteValidation extends CommonMethods {
    @When("the title is {string}")
    public void the_title_is(String string) {
        Assert.assertEquals(string, driver.getTitle());
    }
    @Then("username and password fields are available")
    public void username_and_password_fields_are_available() {
        Assert.assertTrue(loginPage.usernameSlot.isDisplayed());
        Assert.assertTrue(loginPage.passSlot.isDisplayed());

    }
    @Then("Login button is enabled")
    public void login_button_is_enabled() {
        Assert.assertTrue(loginPage.loginBtn.isEnabled());
    }

}
