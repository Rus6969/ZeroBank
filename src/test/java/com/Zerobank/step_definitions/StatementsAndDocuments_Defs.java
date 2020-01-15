package com.Zerobank.step_definitions;

import com.Zerobank.pages.Account_ActivityPage;
import com.Zerobank.pages.StatementsAndDocuments;
import com.Zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementsAndDocuments_Defs {

    @When("the user click on Online Statements")
    public void the_user_click_on_Online_Statements() {

        StatementsAndDocuments statementsAndDocuments=new StatementsAndDocuments();
        statementsAndDocuments.Statement.click();
    }

    @When("the user selects a Year{int}")
    public void the_user_selects_a_Year(Integer  year) {

        switch (year) {
            case (2012):
                StatementsAndDocuments statementsAndDocuments = new StatementsAndDocuments();
                 statementsAndDocuments.twelve.click();
                 break;
            case (2011):
                StatementsAndDocuments statementsAndDocuments1 = new StatementsAndDocuments();
                statementsAndDocuments1.eleven.click();
                break;
            case (2010):
                StatementsAndDocuments statementsAndDocuments2 = new StatementsAndDocuments();
                statementsAndDocuments2.ten.click();
                break;
            case (2009):
                StatementsAndDocuments statementsAndDocuments3=new StatementsAndDocuments();
                statementsAndDocuments3.nine.click();
                break;
            default:
                Assert.fail("Wrong user type provided");
        }

    }

    @Then("{int} should be displayed for that year")
    public void should_be_displayed_for_that_year(Integer count) {



    }
}
