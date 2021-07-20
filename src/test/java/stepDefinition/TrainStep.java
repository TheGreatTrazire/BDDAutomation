package stepDefinition;

import Utils.ActionKeywords;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import var.VariableXpath;

public class TrainStep implements VariableXpath {
    ActionKeywords action = new ActionKeywords();

    @Then("^User goes to train page$")
    public void userGoesToTrainPage() throws Exception {
        action.clickElementXpath(btn_keretaapi);

        if(action.isElementVisible(btn_optional_train_ok)){
            action.clickElementXpath(btn_optional_train_ok);
        }

        //verify element
        action.verifyElementVisible(field_from_tr);
        action.verifyElementVisible(field_to_tr);
        action.verifyElementVisible(field_dep_date_tr);
        action.verifyElementVisible(field_pass_tr);
    }

    @Then("^User choose train departure city$")
    public void userChooseDepCityTr() throws Exception {
        action.clickElementXpath(field_from_tr);
        action.inputText(field_from_tr,"Jakarta");
        action.selectFromDDL(ddc_from_tr);
    }

    @And("^User choose train destination city$")
    public void userChooseDesCityTr() throws Exception {
        action.clickElementXpath(field_to_tr);
        action.inputText(field_to_tr,"Bandung");
        action.selectFromDDL(ddc_to_tr);
    }

    @Then("^User choose train departure date$")
    public void userChooseDepDateTr() throws Exception {
        action.clickElementXpath(field_dep_date_tr);
        action.clickElementXpath(date_dep_tr);
    }

    @Then("User choose {int} adult {int} infant for passenger")
    public void userChoosePassengerTr(int adult, int infant) throws Exception {
        if(adult < 1 || infant < 0){
            throw new java.lang.RuntimeException("adult at least 1");
        }
        else if (adult > 1){
            for(int i = adult; i > 1; i--){
                action.clickElementXpath(inc_adult_tr);
            }
        }

        if (infant >= 1){
            for(int i = infant; i > 0; i--){
                action.clickElementXpath(inc_infant_tr);
            }
        }

        action.clickElementXpath(btn_selesai_tr);
    }

    @Then("^User click Cari Kereta Api Button$")
    public void userCLickCariTrainButton() throws Exception {
        action.clickElementXpath(btn_cari_tr);
        Thread.sleep(2000);
    }

    @When("^User in search train page, verify the page and filter$")
    public void verifySearchPageTr() throws Exception {
        //verify filter
        //Kelas
        action.clickElementXpath(chkbox_filter_tr_eko);
        action.clickElementXpath(chkbox_filter_tr_bus);
        action.clickElementXpath(chkbox_filter_tr_eks);
        //Waktu
        action.clickElementXpath(chkbox_filter_tr_waktu_berangkat_1);
        action.clickElementXpath(chkbox_filter_tr_waktu_berangkat_2);
        action.clickElementXpath(chkbox_filter_tr_waktu_berangkat_3);
        action.clickElementXpath(chkbox_filter_tr_waktu_berangkat_4);
    }

    @Then("^User choose the train dep$")
    public void userChooseTrDep() throws Exception{
        action.verifyElementVisible(lbl_tr_pergi);
        action.clickElementXpath(btn_pilih_tr);
        Thread.sleep(5000);
    }
}
