package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Jay Vaghani
 */
public class LoginPage extends Utility {

    //By welcomeText = By.xpath("");
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement welcomeText;
    //  By emailField = By.id("Email");
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;
    //    By passwordField = By.name("Password");
    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;
    //    By loginButton = By.xpath("//input[@value = 'Log in']");
    @CacheLookup
    @FindBy(xpath = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")
    WebElement loginButton;
    //    By errorMessage = By.xpath("//div[@class = 'validation-summary-errors']");
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement verifyReturnText;


    public String getWelcomeText() {
        String message = getTextFromElement(welcomeText);
        return message;
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + email);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    public String getErrorMessage() {
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS, "Get errorMessage");
        return message;
    }
    public String verifyreturnText() {
        String message = getTextFromElement(verifyReturnText);
        CustomListeners.test.log(Status.PASS, "verify Return Text");
        return message;
    }





}
