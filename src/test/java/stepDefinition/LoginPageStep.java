package stepDefinition;

import Utils.ActionKeywords;
import io.cucumber.java.en.Then;
import var.VariableXpath;

import java.io.FileInputStream;
import java.util.Properties;

public class LoginPageStep implements VariableXpath {
    Properties props = new Properties();
    ActionKeywords action = new ActionKeywords();

    @Then("^User goes to login page$")
    public void userGoesToLoginPage() throws Exception {
        action.clickElementXpath(btn_login);
    }

    @Then("^User input valid email$")
    public void userInputValidEmail() throws Exception {
        FileInputStream fis = new FileInputStream("src//test//resources//props.properties");
        props.load(fis);
        action.inputText(field_email,props.getProperty("email"));
    }

    @Then("^User click Lanjutkan button$")
    public void userClickLanjutButton() throws Exception {
        action.clickElementXpath(btn_lanjutkan);
    }

    @Then("^User input valid password$")
    public void userInputValidPass() throws Exception {
        FileInputStream fis = new FileInputStream("src//test//resources//props.properties");
        props.load(fis);
        action.inputText(field_pass, props.getProperty("pass"));
    }

    @Then("^User click Log in button$")
    public void userCLickLoginButton() throws Exception{
        action.clickElementXpath(btn_logon);
        Thread.sleep(2000);
    }
}
