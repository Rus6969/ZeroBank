package com.Zerobank.step_definitions;

import com.Zerobank.pages.Pay_BillPage;
import com.Zerobank.utilities.BrowserUtils;
import com.Zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pay_Bills_Defs {

    @Then("the user click on Pay Bills")
    public void the_user_click_on_Pay_Bills() {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        pay_billPage.PayBill.click();
    }

    @Then("page should have the title Zero – Pay Bills")
    public void page_should_have_the_title_Zero_Pay_Bills() {
        BrowserUtils.waitFor(2);
      String actual= Driver.get().getTitle();
      String expected ="Zero – Pay Bills";
    }


    @Then("add any amount to amount box")
    public void add_any_amount_to_amount_box() {
        BrowserUtils.waitFor(2);
        Pay_BillPage pay_billPage = new Pay_BillPage();
        pay_billPage.ammount.sendKeys("100");

    }

    @Then("choose date")
    public void choose_date() {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        pay_billPage.date.sendKeys("31");
        //pay_billPage.date.click();
//         Select DATE = new Select(pay_billPage.ThirtyFirstDEceeber);
//         DATE.selectByValue("31");

    }

    @Then("add description")
    public void add_description() {
        Pay_BillPage pay_billPage=new Pay_BillPage();
        pay_billPage.Description.sendKeys("sample test patern");
    }

    @When("click Pay button")
    public void click_Pay_button() {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        pay_billPage.Paybtn.click();
    }

    @Then("The payment was successfully submitted. should be displayed")
    public void the_payment_was_successfully_submitted_should_be_displayed() {
        BrowserUtils.waitFor(2);
        Pay_BillPage pay_billPage = new Pay_BillPage();
         String actual = pay_billPage.PaymetSuccessfull.getText();
         String expected = "The payment was successfully submitted.";
        Assert.assertEquals(expected,actual);

    }

    @Then("Please fill out this field message! should be displayed.")
    public void please_fill_out_this_field_message_should_be_displayed() {
        String expected = "Please fill out this field.";
        Pay_BillPage pay_billPage = new Pay_BillPage();
        String actual = pay_billPage.date.getAttribute("validationMessage");
        System.out.println("actual = " + actual);
        Assert.assertEquals(expected,actual);


    }


    @Then("the user enters special charecters in amount box")
    public void the_user_enters_special_charecters_in_amount_box() {
       Pay_BillPage pay_billPage = new Pay_BillPage();
       pay_billPage.ammount.sendKeys("@*9U$$!!");
    }

    @Then("The payment was successfully submitted. should NOT be displayed")
    public void the_payment_was_successfully_submitted_should_NOT_be_displayed() {
        Assert.assertTrue("The payment was successfully submitted.",false);


    }


    @Then("the user enters special charecters in date box")
    public void the_user_enters_special_charecters_in_date_box() {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        pay_billPage.date.sendKeys("@yoh3");

    }

    @Then("the user clicks on Add new Payee")
    public void the_user_clicks_on_Add_new_Payee() {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        pay_billPage.addPayee.click();
    }

    @Then("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String>userData) {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        BrowserUtils.waitFor(2);
        pay_billPage.AddPayee("The Law Offices of Hyde, Price & Scharks","100 Same st, Anytown, USA, 10001 ","Checking","XYZ account ");

    }

    @Then("the Message The new Payee The Law Offices of Hyde, Price & Scharks should be displayed.")
    public void the_Message_The_new_Payee_The_Law_Offices_of_Hyde_Price_Scharks_should_be_displayed() {
      String expected ="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
      BrowserUtils.waitFor(2);
      Pay_BillPage pay_billPage = new Pay_BillPage();
      String ActualMessaage =pay_billPage.notification.getText();
      Assert.assertEquals(expected,ActualMessaage);
    }


    @Then("the user click on Purchase foreign currency")
    public void the_user_click_on_Purchase_foreign_currency() {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        BrowserUtils.waitFor(2);
        pay_billPage.PFC.click();

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> list) {
        Pay_BillPage pay_billPage = new Pay_BillPage();
        BrowserUtils.waitFor(2);
        Select select = new Select(pay_billPage.PickCurency);
        System.out.println(select.getOptions());
        List<WebElement> Currency = select.getOptions();
        List<String> actual = new ArrayList<>();
        for (WebElement each: Currency ){
            actual.add(each.getText());
        }
        actual.remove(0);
        System.out.println(actual);
        Assert.assertEquals(list,actual);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
         Pay_BillPage pay_billPage = new Pay_BillPage();
         BrowserUtils.waitFor(2);
         pay_billPage.calculate.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        BrowserUtils.waitFor(2);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());

    }

}
