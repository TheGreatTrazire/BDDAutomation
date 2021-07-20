package var;

public interface VariableXpath {
    String btn_login = "//a[text()='Login']";
    String btn_lanjutkan = "//*[@type='button' and contains(text(),'Lanjut')]";
    String btn_logon = "//*[@type='button' and contains(text(),'Log')]";
    String field_email = "//*[@name='username' and @type='text']";
    String field_pass = "//*[@name='password' and @type='password']";
    String label_tiket = "//*[@alt='logo tiket.com']";
    String btn_pesawat = "//div/img[contains(@alt,'Pesawat')]";
    String btn_keretaapi = "//div/img[contains(@alt,'Kereta')]";
    String rdo_oneway = "//*[contains(@id,'oneWay')]/following-sibling::*";
    String rdo_round = "//*[contains(@id,'round')]/following-sibling::*";
    String field_from = "//input[@id='productSearchFrom']";
    String field_to = "//input[@id='productSearchTo']";
    String field_dep_date = "//input[@id='productSearchDeparture']";
    String field_ret_date = "//input[@id='productSearchReturn']";
    String field_pass_cabin = "//input[@id='productSearchPassengerCabin']";

}
