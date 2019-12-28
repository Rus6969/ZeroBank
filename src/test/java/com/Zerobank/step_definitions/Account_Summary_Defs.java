package com.Zerobank.step_definitions;

import com.Zerobank.pages.Account_SummaryPage;
import com.Zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Account_Summary_Defs {


    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> list) {
        System.out.println("listSize "+ list.size());
        System.out.println(list);
        Account_SummaryPage account_summaryPage = new Account_SummaryPage();
        List<String>actualList= new ArrayList<>();
        BrowserUtils.waitFor(2);
        for(WebElement each: account_summaryPage.summaryOption){
            actualList.add(each.getText());

        }
        Assert.assertEquals(list,actualList);

    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String>list) {
        System.out.println("listSize "+ list.size());
        System.out.println(list);
        Account_SummaryPage account_summaryPage = new Account_SummaryPage();
        List<String>actualList = new ArrayList<>();
        BrowserUtils.waitFor(2);
        for (WebElement each : account_summaryPage.CreditAccountsTable){
            actualList.add(each.getText());
        }
         Assert.assertEquals(list,actualList);

    }

}
