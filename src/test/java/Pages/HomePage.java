package Pages;

import Utility.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonMethods {
    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productsText;

    @FindBy (xpath = "//div[@class='app_logo' and text()='Swag Labs']")
    public WebElement appLogo;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement menu_button;

    @FindBy (linkText = "About")
    public WebElement about_button;

    @FindBy (linkText = "Logout")
    public WebElement logout_btn;

    @FindBy(xpath = "//div[@class='inventory_item']//a[contains(@id,'title_link')]")
    public List<WebElement> all_Products_HomePage;

    @FindBy (xpath = "//div[@class='inventory_item']//button")
    public List<WebElement> allProductsAddToCartBtns;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
}
