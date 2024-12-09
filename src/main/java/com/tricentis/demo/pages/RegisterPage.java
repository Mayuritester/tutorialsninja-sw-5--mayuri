package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register']")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "input-firstName")
    WebElement enterFirstName;

    @CacheLookup
    @FindBy(id = "input-lastName")
    WebElement enterLastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement enterConfirmPasssword;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement enterTelephone;

    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    WebElement clickYesOnRadio;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement policyBox;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement clickContinue;




    public String verifyRegisterText() {
        String message = getTextFromElement(registerText);
        CustomListeners.test.log(Status.PASS, "verify register text");
        return message;
    }

    public void enterFirstName(String name) {
        sendTextToElement(enterFirstName, name);
        CustomListeners.test.log(Status.PASS, "enter First Name" + name);

    }

    public void enterLastName(String lastname) {
        sendTextToElement(enterLastName, lastname);
        CustomListeners.test.log(Status.PASS, "enter last Name" + lastname);

    }

    public void enterEmail(String email) {
        sendTextToElement(enterEmail, email);
        CustomListeners.test.log(Status.PASS, "enter email" + email);

    }

    public void enterPassword(String password) {
        sendTextToElement(enterPassword, password);
        CustomListeners.test.log(Status.PASS, "enter password" + password);

    }

    public void enterConfirmPassword(String confirmpassword) {
        sendTextToElement(enterConfirmPasssword, confirmpassword);
        CustomListeners.test.log(Status.PASS, "enter password" + confirmpassword);

    }

    public void entertelehpone(String telephone) {
        sendTextToElement(enterTelephone, telephone);
        CustomListeners.test.log(Status.PASS, "enter telephone" + telephone);

    }

    public void radioYes() {
        clickOnElement(clickYesOnRadio);
        CustomListeners.test.log(Status.PASS, "click yes on radio");
    }

    public void tickPolicyBox() {
        clickOnElement(policyBox);
        CustomListeners.test.log(Status.PASS, "click policy box");
    }

    public void clickContinue() {
        clickOnElement(clickContinue);
        CustomListeners.test.log(Status.PASS, "click continue");
    }
}

