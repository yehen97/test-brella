package testRunner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = "steps",
        plugin = {"json:target/cucumber.json"},tags = {"@ErrorFlow"})
public class cucumberRunner {
}
