package smoketests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features", tags = "@current" ,glue = {"smoketests.stepdefinitions"})
public class RunASingleScenario {}
