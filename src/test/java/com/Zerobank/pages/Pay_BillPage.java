package com.Zerobank.pages;

import com.Zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pay_BillPage {
    public Pay_BillPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "pay_bills_tab")
    public WebElement PayBill;

    @FindBy(id = "sp_amount")
    public WebElement ammount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(xpath = "//select[@name='payee']")
    public WebElement ThirtyFirstDEceeber;

    @FindBy(id = "sp_description")
    public WebElement Description;

    @FindBy(id = "pay_saved_payees")
    public WebElement Paybtn;

    @FindBy(id = "alert_content")
    public WebElement PaymetSuccessfull;

    @FindBy(linkText = "Add New Payee")
    public WebElement addPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement AddNewPayeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement PayeeAdress;

    @FindBy(id = "np_new_payee_account")
    public WebElement PayeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement PayeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement AddAPayee;

    @FindBy(id = "alert_content")
    public WebElement notification;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement PFC;

    @FindBy(id = "pc_currency")
    public WebElement PickCurency;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculate;

    public void AddPayee(String name,String adress,String Account, String details){
       AddNewPayeeName.sendKeys(name);
       PayeeAdress.sendKeys(adress);
       PayeeAccount.sendKeys(Account);
       PayeeDetails.sendKeys(details);
       AddAPayee.click();
    }


}
