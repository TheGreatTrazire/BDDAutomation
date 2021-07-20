package stepDefinition;

import Utils.ActionKeywords;
import io.cucumber.java.en.*;
import var.VariableXpath;

public class FlightStep implements VariableXpath {
    ActionKeywords action = new ActionKeywords();

    @Then("^User goes to flight page$")
    public void userGoesToFlightPage() throws Exception {
        action.clickElementXpath(btn_pesawat);

        //verify element
        action.verifyElementVisible(rdo_oneway);
        action.verifyElementVisible(rdo_round);
        action.verifyElementVisible(field_from);
        action.verifyElementVisible(field_to);
        action.verifyElementVisible(field_dep_date);
        action.verifyElementVisible(field_ret_date);
        action.verifyElementVisible(field_pass_cabin);
    }

    @And("^User choose roundtrip flight$")
    public void userChooseRoundTrip() throws Exception {
        action.clickElementXpath(rdo_round);
    }

    @Then("^User choose departure city$")
    public void userChooseDepCity() throws Exception {
        Thread.sleep(1000);
    }

    @And("^User choose destination city$")
    public void userChooseDesCity() throws Exception {
        Thread.sleep(1000);
    }

    @Then("^User choose departure date$")
    public void userChooseDepDate() throws Exception {
        Thread.sleep(1000);
    }

    @And("^User choose departure date for back$")
    public void userChooseDepDateBack() throws Exception {
        Thread.sleep(1000);
    }

    @Then("^User choose xxx adult xxx kid xxx infant for passenger$")
    public void userChoosePassenger() throws Exception {
        Thread.sleep(1000);
    }

    @Then("^User choose cabin class$")
    public void userChooseCabinClass() throws Exception {
        Thread.sleep(1000);
    }

    @Then("^User click Cari Penerbangan Button$")
    public void userCLickCariFlightButton() throws Exception {
        Thread.sleep(1000);
    }
}
