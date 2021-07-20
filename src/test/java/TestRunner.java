import Utils.SeleniumSetup;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Properties;

@CucumberOptions(
        monochrome = true,
        features = {
                "src/test/resources/features/ProductFlight.feature"
//                "src/test/resources/features/ProductTrain.feature"
        },
        glue = {
                "stepDefinition"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-html-report.html"
        }
)
public class TestRunner {
    Properties props = new Properties();
    private TestNGCucumberRunner testNGCucumberRunner;
    public SeleniumSetup selen = new SeleniumSetup();

    @BeforeTest
    public void openBrowserSelenium() throws Exception{
        FileInputStream fis = new FileInputStream("src//test//resources//props.properties");
        props.load(fis);
        selen.openBrowser(props.getProperty("site"));
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
    @AfterTest
    public void close()
    {
        selen.closeBrowser();
    }
}
