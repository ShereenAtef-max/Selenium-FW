package Runner;


import Tests.TestBase;
import io.cucumber.testng.CucumberOptions;






@CucumberOptions(features = "src/test/java/Features"
,glue= {"Steps"}
,plugin= {"html:target/cucumber-html-report"})
public class TestRunner extends TestBase
{
	




}
