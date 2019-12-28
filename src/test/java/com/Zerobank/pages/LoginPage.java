package com.Zerobank.pages;

import com.Zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement login;

    @FindBy(id = "user_password")
    public WebElement password;
    @FindBy(name = "submit")
    public WebElement LoginBtn;

    @FindBy(xpath = "//form//div[@class='alert alert-error']")
    public WebElement WrongNamePassword;

    public void login(String userNameStr, String passwordStr) {
        login.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        LoginBtn.click();
        // verification that we logged
    }


}
