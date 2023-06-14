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

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
}
