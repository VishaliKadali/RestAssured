package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { 
								//  "src/test/java/features/getIncidents.feature",
								//  "src/test/java/features/getIncidentswithQP.feature",
								//  "src/test/java/features/getIncidentswithQP2.feature",
								//  "src/test/java/features/CreateIncidentwithShort_descCategory.feature",
								//  "src/test/java/features/CreateIncidentByCategory.feature"
									"src/test/java/features/CreateIncident.feature",
								// "src/test/java/features/WK4createIncWithScenarioOutline.feature",
								//  "src/test/java/features/WK4Ass2Incident.feature"
								 
		/* "src/test/java/features/WK4Ass2Incident.feature" */
		/* "src/test/java/features/getIncidents.feature" */
		/* "src/test/java/features/CreateIncidentwithShort_descCategory.feature" */
		//"src/test/java/features/Assign2ChangeRequest.feature",
		//"src/test/java/features/getIncidents.feature"
		}, 
		glue="steps",
		/* glue = { "steps","hooks" }, */
				//	tags ="@Sanity and @Regression", 
					monochrome = true, 
					publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}

/*
 * For example, to use the cucumber-reporting plugin, you can add the following
 * options:
 * 
 * @RunWith(Cucumber.class)
 * 
 * @CucumberOptions(plugin = {"json:target/cucumber-report.json",
 * "html:target/cucumber-report.html"}, features =
 * "src/test/resources/features")
 * 
 * Similarly, to use the cucumber-html-reporter plugin, you can configure it in
 * the @CucumberOptions annotation like this:
 * 
 * @RunWith(Cucumber.class)
 * 
 * @CucumberOptions(plugin =
 * {"com.github.temyers.cucumber.reporting.CucumberHTML:target/cucumber-html-report/cucumber-html-report.html"
 * }) public class MyTestRunner { // ... }
 */
