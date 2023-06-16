package Steps;

import Utility.CommonMethods;
import Utility.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LogoutSteps extends CommonMethods {
    @When("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        clickOn(homePage.logout_btn);
    }
    @Then("the user is taken to the login page")
    public void the_user_is_taken_to_the_login_page() {
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getPropertyValue("url"));
    }

    @When("user adds item #itemNumber to the cart")
    public void user_adds_item_item_number_to_the_cart(DataTable dataTable) {
        List<String> itemsNumber=dataTable.asList(String.class);
        for (String item:itemsNumber){
            addItemToCart(Integer.valueOf(item));
        }
    }

}
