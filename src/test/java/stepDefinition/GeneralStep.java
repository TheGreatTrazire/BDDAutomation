package stepDefinition;

import io.cucumber.java.en.*;
import Utils.SeleniumSetup;
import Utils.ActionKeywords;
import var.VariableXpath;

import java.io.FileInputStream;
import java.util.Properties;

public class GeneralStep implements VariableXpath {
    Properties props = new Properties();
    SeleniumSetup selen = new SeleniumSetup();
    ActionKeywords action = new ActionKeywords();

    @Given("^User is on tiket homepage$")
    public void userOnTiketHomepage() throws Exception {
        action.verifyElementVisible(label_tiket);
        action.verifyElementVisible(btn_pesawat);
        action.verifyElementVisible(btn_keretaapi);
    }

    @Then("^User should go to homepage$")
    public void userGoesToHomepage() throws Exception{
        FileInputStream fis = new FileInputStream("src//test//resources//props.properties");
        props.load(fis);
        selen.getDriver().get(props.getProperty("site"));
        Thread.sleep(1000);
    }
}
