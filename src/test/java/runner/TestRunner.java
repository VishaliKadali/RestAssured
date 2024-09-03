package runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import hooks.RetryListener;

@Listeners(RetryListener.class)
@CucumberOptions(features = { 
								//  "src/test/java/features/getIncidents.feature",
								//  "src/test/java/features/getIncidentswithQP.feature",
								//  "src/test/java/features/getIncidentswithQP2.feature",
								//  "src/test/java/features/CreateIncidentwithShort_descCategory.feature",
								//  "src/test/java/features/CreateIncidentByCategory.feature"
								//	"src/test/java/features/CreateIncident.feature",
								// 	"src/test/java/features/WK4createIncWithScenarioOutline.feature",
									"src/test/java/features/Validation2.feature"
								//  "src/test/java/features/WK4Ass2Incident.feature"
								//	"src/test/java/features/background.feature"
								//	"src/test/java/features/hooks.feature" 
							
		/* "src/test/java/features/WK4Ass2Incident.feature" */
		/* "src/test/java/features/getIncidents.feature" */
		/* "src/test/java/features/CreateIncidentwithShort_descCategory.feature" */
		//"src/test/java/features/Assign2ChangeRequest.feature",
		//"src/test/java/features/getIncidents.feature"
		},
		plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html"},
		glue="steps",
				
		// glue = { "steps","hooks" }, 
				//	tags ="@Sanity and @Regression", 
					monochrome = true, 
					publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {

	private String timestamp;
    private String reportDirPath;
    
    @BeforeClass
    public void setup() {
        timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        reportDirPath = "target/cucumber-reports-" + timestamp;
        System.setProperty("cucumber.report.path", reportDirPath);
        
        // Ensure the timestamped report directory exists
        File reportDir = new File(reportDirPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
    }

    @AfterClass
    public void teardown() {
        // Move the cucumber report to the new directory if it was generated
        File sourceReport = new File("target/cucumber-reports/cucumber-report.html");
        File destReport = new File(reportDirPath, "cucumber-report.html");

        if (sourceReport.exists()) {
            sourceReport.renameTo(destReport);
        }
    }
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
