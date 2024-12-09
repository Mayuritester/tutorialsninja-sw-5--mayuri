package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement verifyLaptopAndNotebooksText;

    @CacheLookup
    @FindBy(id= "input-sort")
    WebElement sortDropDown ;

    @CacheLookup
    @FindBy(xpath= "//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]")
    WebElement clickOnMacBook;

    @CacheLookup
    @FindBy(id= "//h1[contains(text(),'MacBook')]")
    WebElement macbookText ;

    public String verifyLaptopAndNotebooksText (){
       String message = getTextFromElement(verifyLaptopAndNotebooksText);
        CustomListeners.test.log(Status.PASS,"Verify Laptop and Notebook Text" + verifyLaptopAndNotebooksText);
       return message;
    }
    public void selectSortByPriceHighTOlow(String type){
        selectByVisibleTextFromDropDown(sortDropDown, "Price (High > Low)");
        CustomListeners.test.log(Status.PASS,"High to low");
        Reporter.log("Clicking on High to low" +  sortDropDown.toString());
    }

    public void setClickOnMacBook (){
        clickOnElement(clickOnMacBook);
        CustomListeners.test.log(Status.PASS,"click on Macbook");
    }

    public String verifyMacbook (){
        String message = getTextFromElement(macbookText);
        CustomListeners.test.log(Status.PASS,"Verify Macbook" + macbookText);
        return message;
    }
}
