package com.Zerobank.pages;

import com.Zerobank.utilities.BrowserUtils;
import com.Zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Account_ActivityPage {
    public Account_ActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id = "aa_type")
    public  WebElement Type;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivity;

    @FindBy(id = "aa_accountId")
    public WebElement accountDropDown;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> DDDW;

    @FindBy(linkText = "Find Transactions")
    public WebElement FindTrans;

    @FindBy(id = "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(css = "button")
    public WebElement Find;

    @FindBy(xpath = "(//tbody)[2]//tr[2]//td[1]")
    public WebElement between;

    @FindBy(xpath = "(//tbody)[2]//tr//td[1]")
    public List<WebElement> DateList;

    @FindBy(name = "description")
    public WebElement description;

    @FindBy(xpath = "(//tbody)[2]//tr//td[2]")
    public List<WebElement> OnlineOffice;

    @FindBy(xpath = "(//tbody)[2]//tr//td[3]")
    public List<WebElement> UnderDepsit;
    @FindBy (xpath = "(//tbody)[2]//tr//td[4]")
    public List<WebElement> UnderWithdrow;

    public void checkIfSAme(String str){
        for(WebElement each : OnlineOffice){
            Assert.assertTrue(each.getText().startsWith(str));
        }
    }


    public void setDescription(String str) {
        BrowserUtils.waitFor(2);
        description.sendKeys(str);
        Find.click();
        description.clear();
    }

    public void giveDateRange(String from, String to) {
        dateFrom.sendKeys(from);
        dateTo.sendKeys(to);
        Find.click();

    }

    public void FindInDateRangeOrNot(String start, String finish, String middle) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long from = sdf.parse(start).getTime() / 36000000;
        System.out.println("from = " + from);
        long between = sdf.parse(middle).getTime() / 36000000;
        System.out.println("between = " + between);
        long to = sdf.parse(finish).getTime() / 36000000;
        System.out.println("to = " + to);
        Assert.assertTrue(between > from && between < to);
    }

}
