package stepDefinition;

import Utils.ActionKeywords;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        action.clickElementXpath(field_from);
        action.inputText(field_from,"JKTC");
        action.selectFromDDL(ddc_from);
    }

    @And("^User choose destination city$")
    public void userChooseDesCity() throws Exception {
        action.clickElementXpath(field_to);
        action.inputText(field_to,"Surabaya");
        action.selectFromDDL(ddc_to);
    }

    @Then("^User choose departure date$")
    public void userChooseDepDate() throws Exception {
        action.clickElementXpath(field_dep_date);
        action.clickElementXpath(date_dep);
    }

    @And("^User choose departure date for back$")
    public void userChooseDepDateBack() throws Exception {
        action.clickElementXpath(field_ret_date);
        action.clickElementXpath(date_back);
    }

    @Then("User choose {int} adult {int} kid {int} infant for passenger")
    public void userChoosePassenger(int adult, int kid, int infant) throws Exception {
        if(adult < 1 || kid < 0 || infant < 0){
            throw new java.lang.RuntimeException("adult at least 1");
        }
        else if (adult > 1){
            for(int i = adult; i > 1; i--){
                action.clickElementXpath(inc_adult);
            }
        }
        if (kid >= 1){
            for(int i = kid; i > 0; i--){
                action.clickElementXpath(inc_kid);
            }
        }
        if (infant >= 1){
            for(int i = infant; i > 0; i--){
                action.clickElementXpath(inc_infant);
            }
        }
    }

    @Then("^User choose cabin class$")
    public void userChooseCabinClass() throws Exception {
        action.clickElementXpath(btn_ekonomi);
        action.clickElementXpath(btn_selesai);
    }

    @Then("^User click Cari Penerbangan Button$")
    public void userCLickCariFlightButton() throws Exception {
        action.clickElementXpath(btn_cari_flight);
    }

    @When("^User in search page, verify the page and filter$")
    public void verifySearchPage() throws Exception {
        if(action.isElementVisible(btn_mengerti)){
            action.clickElementXpath(btn_mengerti);
        }
        //verify filter
        //Transit
        action.clickElementXpath(chkbox_filter_transit_langsung);
        action.clickElementXpath(chkbox_filter_transit_1);
        action.clickElementXpath(chkbox_filter_transit_2);

        //Durasi Transit
        action.verifyElementVisible(slider_filter_durasi_transit);
        //Waktu
        action.clickElementXpath(chkbox_filter_waktu_berangkat_1);
        action.clickElementXpath(chkbox_filter_waktu_berangkat_2);
        action.clickElementXpath(chkbox_filter_waktu_berangkat_3);
        action.clickElementXpath(chkbox_filter_waktu_berangkat_4);
        action.clickElementXpath(chkbox_filter_waktu_tiba_1);
        action.clickElementXpath(chkbox_filter_waktu_tiba_2);
        action.clickElementXpath(chkbox_filter_waktu_tiba_3);
        action.clickElementXpath(chkbox_filter_waktu_tiba_4);
        //Jenis Tarif
        action.clickElementXpath(chkbox_filter_jenis_tarif_clean);
        action.clickElementXpath(chkbox_filter_jenis_tarif_flexy);
        //Fasilitas
        action.clickElementXpath(chkbox_filter_fasilitas_bagasi);
        action.clickElementXpath(chkbox_filter_fasilitas_hiburan);
        action.clickElementXpath(chkbox_filter_fasilitas_makanan);
        //Durasi Perjalanan
        action.verifyElementVisible(slider_filter_durasi_perjalanan);
    }

    @Then("^User choose the flight dep$")
    public void userChooseFlightDep() throws Exception{
        action.verifyElementVisible(lbl_penerbangan_pergi);
        action.clickElementXpath(btn_pilih_penerbangan);
        Thread.sleep(5000);
    }

    @Then("^User choose the flight ret$")
    public void userChooseFlightRet() throws Exception{
        action.verifyElementVisible(lbl_penerbangan_pulang);
        action.clickElementXpath(btn_pilih_penerbangan);
        Thread.sleep(5000);
    }

    @When("^User in detail page, enter passenger detail$")
    public void enterPassengerDetail() throws Exception {
        action.clickElementXpath(swc_same_with_acc);
        action.clickElementXpath(ddl_nationality);
        action.selectFromDDL(ddl_nationality_idr);
        action.clickElementXpath(btn_goes_to_payment);
        action.clickElementXpath(btn_confirm);
        Thread.sleep(5000);
    }

    @Then("^User choose BCA VA and continue$")
    public void userChooseBCAVA() throws Exception{
        action.clickElementXpath(btn_bca_va);
        action.clickElementXpath(btn_payment_continue);
        Thread.sleep(5000);
    }

    @And("^Verify detail payment page (VA Number)$")
    public void verifyVANumber() throws Exception {
        action.clickElementXpath(lbl_va_number);
    }
}
