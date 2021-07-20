package stepDefinition;

import io.cucumber.java.en.*;

public class GeneralStep {
    @Given("^User is on tiket homepage$")
    public void userOnTiketHomepage() throws Exception {
        Thread.sleep(1000);
    }

    @Then("^User should go to homepage$")
    public void userGoesToHomepage() throws Exception{
        Thread.sleep(1000);
    }
}
