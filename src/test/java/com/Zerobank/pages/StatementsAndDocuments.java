package com.Zerobank.pages;

import com.Zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatementsAndDocuments {
    public StatementsAndDocuments(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(linkText ="Online Statements")
     public WebElement Statement;

    @FindBy(xpath = "//li[.='2012']")
    public WebElement twelve;

    @FindBy(xpath = "//li[.='2011']")
    public WebElement eleven;

    @FindBy(xpath = "//li[.='2010']")
    public WebElement ten;

    @FindBy(xpath = "//li[.='2009']")
    public WebElement nine;

    @FindBy(xpath = "(//tbody)[2]")
    public List<WebElement> table;



}
