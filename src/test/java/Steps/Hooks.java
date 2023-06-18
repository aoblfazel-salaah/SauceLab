package Steps;

import Utility.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {
    @Before
    public static void preConditions(){
        openBrowserAndNavigateToUrl();
    }
    @After
    public static void postConditions(Scenario scenario){
        byte [] pic;

        if (scenario.isFailed()){
            pic= screenshotAs("Failed/"+scenario.getName());
        }else {
            pic= screenshotAs("Passed/"+scenario.getName());
        }

        scenario.attach(pic, "image/png", scenario.getName());
        closeBrowser();
    }
}
