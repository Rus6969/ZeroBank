package com.Zerobank.step_definitions;
import com.Zerobank.pages.Account_ActivityPage;
import com.Zerobank.pages.Account_SummaryPage;
import com.Zerobank.utilities.BrowserUtils;
import com.Zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Account_Activity_Defs {
    @When("User click on Account activity tab")
    public void user_click_on_Account_activity_tab() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        account_activityPage.accountActivity.click();

    }

    @Then("page should have the title Zero – Account activity")
    public void page_should_have_the_title_Zero_Account_activity() {
        BrowserUtils.waitFor(2);
        String expected = "Zero - Account Activity";
        String actual = Driver.get().getTitle();
        Assert.assertEquals(expected, actual);
    }

    @Then("default option should be Savings")
    public void default_option_should_be_Savings() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        Select options = new Select(account_activityPage.accountDropDown);
        List<WebElement> list = options.getOptions();
        String actual = list.get(0).getText();
        System.out.println("actual = " + actual);
        String expected = "Savings";
        Assert.assertEquals(expected, actual);
    }

    @Then("drop Down option should be :")
    public void drop_Down_option_should_be(List<String> expected) {
        System.out.println("expected = " + expected);
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        Select options = new Select(account_activityPage.accountDropDown);
        List<WebElement> Options = options.getOptions();
        List<String> actual = new ArrayList();
        for (WebElement each : Options) {
            actual.add(each.getText());
        }
        Assert.assertEquals(expected, actual);

    }

    @Then("Transaction table options are:")
    public void transaction_table_options_are(List<String> expected) {
        System.out.println("expected = " + expected);
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        List<String> actual = new ArrayList<>();
        BrowserUtils.waitFor(2);
        for (WebElement each : account_activityPage.DDDW) {
            actual.add(each.getText());
        }
        Assert.assertEquals(expected, actual);
    }

    @Then("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        // Write code here that turns the phrase above into concrete actions
        Account_SummaryPage account_summaryPage = new Account_SummaryPage();
        account_summaryPage.Brokerage.click();
    }
    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        Select options = new Select(account_activityPage.accountDropDown);
        String actual = options.getFirstSelectedOption().getText();
        System.out.println("actual = " + actual);
        String expected = "Brokerage";
        Assert.assertEquals(expected, actual);

    }
    @When("User click on Find Transactions tab")
    public void user_click_on_Find_Transactions_tab() {
       Account_ActivityPage account_activityPage = new Account_ActivityPage();
       account_activityPage.FindTrans.click();
    }

    @When("the user enters date range from {string} to {string} and click search")
    public void the_user_enters_date_range_from_to_and_click_search(String string, String string2) {
        BrowserUtils.waitFor(2);
       Account_ActivityPage account_activityPage= new Account_ActivityPage();
       account_activityPage.giveDateRange("2012-09-01","2012-09-06");
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2 ) throws ParseException {
          Account_ActivityPage account_activityPage = new Account_ActivityPage();
          BrowserUtils.waitFor(2);
          String bet = account_activityPage.between.getText();
          BrowserUtils.waitFor(2);
          account_activityPage.FindInDateRangeOrNot("2012-09-02", "2012-09-06", bet);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
     Account_ActivityPage account_activityPage = new Account_ActivityPage();
     List<String>actual = new ArrayList<>();
     List<String> expected = new ArrayList<>();
        for (WebElement each: account_activityPage.DateList) {
            actual.add(each.getText());
            expected.add(each.getText());
        }
        System.out.println("actual = " + actual);
        Collections.sort(expected,Collections.reverseOrder());
        System.out.println("expected = " + expected);
        Assert.assertEquals(expected,actual);
    }


    @When("user adds description")
    public void user_adds_description() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        account_activityPage.setDescription("ONLINE");
    }

    @Then("results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_ONLINE() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        account_activityPage.checkIfSAme("ONLINE");

    }

    @Then("results table should only show descriptions containing “OFFICE”")
    public void results_table_should_only_show_descriptions_containing_OFFICE() {
        Account_ActivityPage account_activityPage =new Account_ActivityPage();
        account_activityPage.setDescription("OFFICE");

        account_activityPage.checkIfSAme("OFFICE");
    }

    @When("the user enters description “online”")
    public void the_user_enters_description_online() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        account_activityPage.checkIfSAme("online");
    }



    @When("User click find")
    public void user_click_find() {
       Account_ActivityPage account_activityPage = new Account_ActivityPage();
       BrowserUtils.waitFor(2);
       account_activityPage.Find.click();
    }

    @Then("result shoud contain at least one result under deposit and under withdrow")
    public void result_shoud_contain_at_least_one_result_under_deposit_and_under_withdrow() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        List<String> actualDeposit = new ArrayList<>();
        BrowserUtils.waitFor(2);
        for (WebElement each:account_activityPage.UnderDepsit){
            actualDeposit.add(each.getText());
        }
        System.out.println(actualDeposit);
        Assert.assertFalse(actualDeposit.isEmpty());
        List<String> actualWithdrawal = new ArrayList<>();
        for (WebElement each:account_activityPage.UnderWithdrow){
            actualWithdrawal.add(each.getText());
        }
        System.out.println("actualWithdrawal = " + actualWithdrawal);
        Assert.assertFalse(actualWithdrawal.isEmpty());
    }


    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
        Account_ActivityPage account_activityPage= new Account_ActivityPage();
        BrowserUtils.waitFor(2);
       Select select= new Select(account_activityPage.Type);
       select.selectByIndex(1);
       account_activityPage.Find.click();


    }

    @Then("result shoud contain at least one result under deposit but  withdrawal should be empty")
    public void result_shoud_contain_at_least_one_result_under_deposit_but_withdrawal_should_be_empty() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        List<String> actualDep = new ArrayList<>();
        BrowserUtils.waitFor(2);
        for (WebElement each:account_activityPage.UnderDepsit){
            actualDep.add(each.getText());
        }
        System.out.println(actualDep);
        Assert.assertFalse(actualDep.isEmpty());

        List<String> actualWithdrawal = new ArrayList<>();
        for (WebElement each:account_activityPage.UnderWithdrow){
            actualWithdrawal.add(each.getText());
        }
        System.out.println("actualWithdrawal = " + actualWithdrawal);
        actualWithdrawal.clear();
        System.out.println("actualWithdrawal = " + actualWithdrawal);
        Assert.assertTrue(actualWithdrawal.isEmpty());
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        BrowserUtils.waitFor(2);
       Select select = new Select(account_activityPage.Type);
       select.selectByIndex(2);
       account_activityPage.Find.click();
    }

    @Then("results table should show at least one result under Withdrawal But results table should show no result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Withdrawal_But_results_table_should_show_no_result_under_Deposit() {
        Account_ActivityPage account_activityPage = new Account_ActivityPage();
        List<String> actualWithd = new ArrayList<>();
        for (WebElement each:account_activityPage.UnderWithdrow){
            actualWithd.add(each.getText());
        }
        System.out.println("actualWithdrawal = " + actualWithd);
        Assert.assertFalse(actualWithd.isEmpty());

        List<String> actualDep = new ArrayList<>();
        BrowserUtils.waitFor(2);
        for (WebElement each:account_activityPage.UnderDepsit){
            actualDep.add(each.getText());
        }
        System.out.println("actualDep = " + actualDep);
        actualDep.clear();
        Assert.assertTrue(actualDep.size()==0);


    }



}


