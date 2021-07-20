import Utils.SeleniumSetup;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = {
                "src/test/resources/features/login.feature"
        },
        glue = {
                "stepDefinition"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-html-report"
        }
)
public class TestRunner{
    private TestNGCucumberRunner testNGCucumberRunner;
    public SeleniumSetup selen = new SeleniumSetup();

    @BeforeSuite
    public void openBrowserSelenium(){
        selen.openBrowser("https://www.tiket.com/");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios",invocationCount = 1)
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }


    @AfterClass(
            alwaysRun = true
    )
    public void tearDownClass() {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }
    @AfterSuite
    public void close()
    {
        selen.closeBrowser();
    }
}
