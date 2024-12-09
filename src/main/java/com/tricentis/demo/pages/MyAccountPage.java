package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement verifyYourAccountHasBeenCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement clickContiue;

    @CacheLookup
    @FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]")
    WebElement logoutText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement clickContiue1;


    public String setVerifyYourAccountHasBeenCreatedText (){
        String message = getTextFromElement(verifyYourAccountHasBeenCreatedText);
        CustomListeners.test.log(Status.PASS, "verify your account has been created text");
        return message;
    }
public void clickContinue (){
        clickOnElement(clickContiue);
    CustomListeners.test.log(Status.PASS, "click Continue");
}
    public String setVerifyLogOutText (){
        String message = getTextFromElement(logoutText);
        CustomListeners.test.log(Status.PASS, "verify LogOut text");
        return message;
    }
    public void clickContinue1 (){
        clickOnElement(clickContiue1);
        CustomListeners.test.log(Status.PASS, "click Continue");
    }
}
