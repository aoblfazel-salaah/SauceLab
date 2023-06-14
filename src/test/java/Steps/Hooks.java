package Steps;

import Utility.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends CommonMethods {
    @Before
    public static void preConditions(){
        openBrowserAndNavigateToUrl();
    }
    @After
    public static void postConditions(){
        closeBrowser();
    }
}
