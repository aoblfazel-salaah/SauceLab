package Pages;

import Utility.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {
    @FindBy (id = "user-name")
    public WebElement usernameSlot;

    @FindBy (id = "password")
    public WebElement passSlot;

    @FindBy (id = "login-button")
    public WebElement loginBtn;

    @FindBy (xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    public LoginPage (){
        PageFactory.initElements(driver,this);
    }
}
