package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage  extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopText ;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputer ;

    @CacheLookup
    @FindBy(id= "input-sort")
    WebElement sortDropDown ;

    @CacheLookup
    @FindBy(xpath= "//a[normalize-space()='HTC Touch HD']")
    WebElement htcTouchHd ;

    @CacheLookup
    @FindBy(xpath= "//input[@id='input-quantity']")
    WebElement qtyBox ;

    @CacheLookup
    @FindBy(xpath= "//img[@class='img-responsive']")
    WebElement allproducts;

    public String desktopText (){
        getTextFromElement(desktopText);
        String message = getTextFromElement(desktopText);
                return message;



    }

    public void clickOnBuildYourOwnComputer (){
        clickOnElement(buildYourOwnComputer);
        CustomListeners.test.log(Status.PASS,"Click on Build your own Computer");
        Reporter.log("Clicking on Build your own computer" +  buildYourOwnComputer.toString());
    }

    public void selectSortByPostionZtoA(String type){
        selectByVisibleTextFromDropDown(sortDropDown, "Name (Z - A)");
        CustomListeners.test.log(Status.PASS,"Click on Build your own Computer");
        Reporter.log("Clicking on z - a" +  sortDropDown.toString());
    }


       public void selectProductSorting(String type) {
           selectByVisibleTextFromDropDown(sortDropDown, type);
           Reporter.log("sorting from dropdown  menu Z to A" + sortDropDown.toString());
       }

    public void selectSortByPostionAtoZ(String type){
        selectByVisibleTextFromDropDown(sortDropDown, "Name (A - Z)");
        CustomListeners.test.log(Status.PASS,"Click on Build your own Computer");
        Reporter.log("Clicking on Build your own computer" +  buildYourOwnComputer.toString());
    }

    public void clickOnHTCtouchHD(String hdd){
        clickOnElement(htcTouchHd);
        CustomListeners.test.log(Status.PASS,"Click on HTC Touch HD");
        Reporter.log("Clicking on HTC touch " +  htcTouchHd.toString());
    }

   }

