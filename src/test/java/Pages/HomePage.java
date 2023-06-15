package Pages;

import Utility.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonMethods {
    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productsText;

    @FindBy (xpath = "//div[@class='app_logo' and text()='Swag Labs']")
    public WebElement appLogo;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement menu_button;

    @FindBy (linkText = "About")
    public WebElement about_button;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
}
