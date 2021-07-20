package stepDefinition;

import io.cucumber.java.en.*;
import Utils.SeleniumSetup;

import java.io.FileInputStream;
import java.util.Properties;

public class GeneralStep {
    Properties props = new Properties();
    SeleniumSetup selen = new SeleniumSetup();
    @Given("^User is on tiket homepage$")
    public void userOnTiketHomepage() throws Exception {
        Thread.sleep(1000);
    }

    @Then("^User should go to homepage$")
    public void userGoesToHomepage() throws Exception{
        FileInputStream fis = new FileInputStream("src//test//resources//props.properties");
        props.load(fis);
        selen.openBrowser(props.getProperty("site"));
        Thread.sleep(1000);
    }
}
