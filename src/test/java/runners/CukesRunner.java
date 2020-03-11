package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports", //generates every time we run the cukes runner
                "json:target/cucumber.json",  // thats just naming the report
                "junit:target/cucumber.xml"

        },

        tags= {"@login"},
        features= "src/test/features",
        glue= "src/test/step_definitions",
        dryRun = false
)
public class CukesRunner {}