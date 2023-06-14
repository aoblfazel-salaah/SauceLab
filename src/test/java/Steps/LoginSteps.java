package Steps;

import Utility.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps extends CommonMethods {
    @Given("username is entered {string}")
    public void username_is_entered(String string) {
        sendText(loginPage.usernameSlot, string);
    }
    @Given("Password is entered {string}")
    public void password_is_entered(String string) {
        sendText(loginPage.passSlot, string);
    }
    @Given("user clicks on login button")
    public void user_clicks_on_login_button() {
        clickOn(loginPage.loginBtn);
    }
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(homePage.appLogo.isDisplayed());
        Assert.assertTrue(homePage.productsText.isDisplayed());
    }

    //------------invalid login----------

    @Then("user gets the {string}")
    public void user_gets_the(String string) {
        Assert.assertTrue(loginPage.errorMessage.getText().contains(string));
    }
}
