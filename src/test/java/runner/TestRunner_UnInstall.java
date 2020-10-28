package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},
//        features={"src/test/java/features/AMS01_DashcamProvisioning_E2E.feature","src/test/java/features/AMS02_DashcamProvisioning_Parameterization.feature"},
         glue = {"stepDefinitions"},

        monochrome = true,
        strict = true,
        plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-html-report"},
        dryRun = false,
        tags = {"@test4"}


)



//@CucumberOptions(
//        features = {"AMS01_DashcamProvisioning_E2E.feature"},
//        glue= {"stepDefinitions"},
//        tags= {"@Test1, @Test2"},
//        plugin = { "pretty", "html:target/htmlreports" }
//)

public class TestRunner_UnInstall extends AbstractTestNGCucumberTests {


    }







