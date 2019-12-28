package com.Zerobank.pages;

import com.Zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Account_SummaryPage {
    public Account_SummaryPage(){ PageFactory.initElements(Driver.get(),this); }
  @FindBy(xpath = "//h2")
    public List<WebElement> summaryOption;

    @FindBy(xpath = "(//thead)[3]//th")
    public List<WebElement> CreditAccountsTable;

    @FindBy(xpath = "(//tbody)[2]//a")
    public WebElement Brokerage;

}
