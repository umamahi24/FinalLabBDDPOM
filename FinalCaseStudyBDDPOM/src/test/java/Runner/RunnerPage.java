package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src//test//resources//features//ConduitCRUD.feature",
		glue= {"stepsDef"},
		plugin= {"pretty", "html:target//Reports//HtmlReport.html",
				 //"usage:target//Reports//usageReport",
				 //"json:target//Reports//jsonReport.json"
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
	   //, monochrome = true
			   
	   //, dryRun=true
	   )
public class RunnerPage extends AbstractTestNGCucumberTests{
	
//	@DataProvider(parallel=true)
//	public Object[][]  scenarios(){
//		return super.scenarios();
//	}

}


