package Steps;

import Pages.HomePage;
import Utility.CommonMethods;
import Utility.ExcelReader;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class ValidateAppropriatePrices extends CommonMethods {

    @Then("every item's price should match the price list in the {string} excel file")
    public void every_item_s_price_should_match_the_price_list_in_the_items_and_prices_excel_file(String sheetName) {
        List <Map<String,String>> itemsAndPrices=ExcelReader.readExcelFile(sheetName);
        int i=0;
        for (var map:itemsAndPrices){
            Assert.assertEquals(map.get("Product"),homePage.all_Products_HomePage_Names.get(i).getText());
            System.out.println(map.get("Product")+" : "+homePage.all_Products_HomePage_Names.get(i).getText());
            Assert.assertEquals(map.get("Price"), homePage.allPrices.get(i).getText());
            System.out.println(map.get("Price")+" : "+ homePage.allPrices.get(i).getText());
            i+=1;
        }
    }
}
