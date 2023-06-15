package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Steps",
        dryRun = false,
        tags = "@reg",
        plugin = {"pretty", "html:target/report.html",
                            "json:target/report.json"}

)
public class RegressionRunner {

}
