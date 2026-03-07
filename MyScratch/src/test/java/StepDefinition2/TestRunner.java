package StepDefinition2;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.*;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features="src/test/java/FeatureFiles/",
	glue= {"StepDefinition2"},
	//tags="@smoke"
	//tags="@smoke and @sanity"
	//tags="@smoke and @sanity"
	tags="@sanity" ,
	
	//dryRun=true//Not running error displayed	
	dryRun=false,//error displayed for undefined scenario in feature file remaining scenaro's are executed
	monochrome=false,//To remove color on reports
	plugin= {"pretty","html:target/HtmlReports/index.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
	
)
public class TestRunner {

}
