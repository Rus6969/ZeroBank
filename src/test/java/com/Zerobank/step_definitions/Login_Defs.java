package com.Zerobank.step_definitions;

import com.Zerobank.pages.LoginPage;
import com.Zerobank.utilities.BrowserUtils;
import com.Zerobank.utilities.ConfigurationReader;
import com.Zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class Login_Defs {

    @Given("User is on Login page")
    public void user_is_on_Login_page() {
        Driver.get().manage().window().maximize();
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the users enters the valid credentials")
    public void the_users_enters_the_valid_credentials() {
        LoginPage loginPage = new LoginPage();
        String userName= ConfigurationReader.get("username");
        String userPassword = ConfigurationReader.get("password");
        loginPage.login(userName,userPassword);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
       String title= Driver.get().getTitle();
        System.out.println("title = " + title);
        Assert.assertEquals("Zero - Account Summary",title);

    }

    @When("the users enters the INvalid credentials")
    public void the_users_enters_the_INvalid_credentials() {
        LoginPage loginPage = new LoginPage();
        String userName= ConfigurationReader.get("WrongUserName");
        String userPassword = ConfigurationReader.get("password");
        loginPage.login(userName,userPassword);

    }

    @Then("error message Login and\\/or password are wrong. should be displayed.")
    public void error_message_Login_and_or_password_are_wrong_should_be_displayed() {
        BrowserUtils.waitFor(2);
        LoginPage loginPage=new LoginPage();
        Assert.assertTrue( loginPage.WrongNamePassword.isDisplayed());
    }

}
