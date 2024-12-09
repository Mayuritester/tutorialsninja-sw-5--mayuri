package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacbookPage extends Utility {
    @CacheLookup
    @FindBy(xpath= "//input[@id='input-quantity']")
    WebElement qtyBox ;

    @CacheLookup
    @FindBy(xpath= "//button[@type='submit']")
    WebElement clickUpdate ;

    @CacheLookup
    @FindBy(xpath= "//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
    WebElement verifyTotal ;

    @CacheLookup
    @FindBy(xpath= "//a[@class='btn btn-primary']")
    WebElement clickCheckoout  ;

    public void enterQTY (){
       sendTextToElement(qtyBox, "2");
        CustomListeners.test.log(Status.PASS,"Change qty to 2");
    }
    public void clickupdate (){
        clickOnElement(clickUpdate);
        CustomListeners.test.log(Status.PASS,"click update");
    }
    public String verifyUpdate (){
        String message = getTextFromElement(clickUpdate);
        CustomListeners.test.log(Status.PASS,"verify update");
   return message;
    }
    public void clickCechkout (){
        clickOnElement(clickCheckoout);
        CustomListeners.test.log(Status.PASS,"click checkout");
    }
    public String verifyTotal (){
        String message = getTextFromElement(verifyTotal);
        CustomListeners.test.log(Status.PASS,"verify total");
        return message;
    }

}
