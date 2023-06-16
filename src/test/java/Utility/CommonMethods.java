package Utility;

import Steps.PageInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndNavigateToUrl(){
        ConfigReader.readProperties();
        String browser = ConfigReader.getPropertyValue("browser");

        switch (browser){

            case "chrome":
                driver=new ChromeDriver();
                break;
            case "headless":
                ChromeOptions ops=new ChromeOptions();
                ops.addArguments("--headless");
                driver = new ChromeDriver(ops);

        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        initializePageObjects();
    }

    public static void closeBrowser(){
        driver.close();
    }

    public static void sendText(WebElement e,String s){
        e.clear();
        e.sendKeys(s);
    }

    public static void clickOn(WebElement e){
        e.click();
    }

    public static void addItemToCart(Integer i){
        WebElement itemToChoose= homePage.allProductsAddToCartBtns.get(i);
        clickOn(itemToChoose);
    }
}
