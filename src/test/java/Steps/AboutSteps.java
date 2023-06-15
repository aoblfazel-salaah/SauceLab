package Steps;

import Utility.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutSteps extends CommonMethods {
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    String about_page_title;
    @When("user clicks on menu button")
    public void user_clicks_on_menu_button() {
        clickOn(homePage.menu_button);
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(homePage.about_button));
        Assert.assertTrue(element.isDisplayed());
    }
    @When("clicks on about button")
    public void clicks_on_about_button() {
        String currentWindowTitle = driver.getTitle();
        clickOn(homePage.about_button);
        about_page_title= driver.getTitle();
        Assert.assertNotEquals(currentWindowTitle,about_page_title);
    }
    @Then("user is taken to about page")
    public void user_is_taken_to_about_page() {
        Assert.assertEquals(about_page_title,
                "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
        Assert.assertEquals(driver.getCurrentUrl(),"https://saucelabs.com/");
    }

}
