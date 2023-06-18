package Utility;

import Steps.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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

    public static byte [] screenshotAs(String imageName){
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        byte [] picBytes= takesScreenshot.getScreenshotAs(OutputType.BYTES);
        File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File(
                    Constants.SCREENSHOT_FILEPATH
                                        +imageName
                                        +getTimeStamp("yyyy-MM-dd -- HH:mm:ss")
                                        +".png"));
        } catch (IOException e) {
            throw new RuntimeException("SS filepath");
        }
        return picBytes;
    }

    public static String getTimeStamp (String pattern){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
