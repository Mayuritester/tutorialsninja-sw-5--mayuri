package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentLink;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currancyDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    WebElement poundLink;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountLink;




    public void selectMenu(String menu) {
        List<WebElement> topMenuList = getListOfElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    public void clickOnDesktop() {
        clickOnElement(desktopLink);
        CustomListeners.test.log(Status.PASS, "Click on Desktop");

    }

    public void mouseHoverOnLaptopsAndNotebooks() {
       clickOnElement(laptopsAndNotebooksLink);
        CustomListeners.test.log(Status.PASS, "Mouse hover on Laptop and Notebooks and click");
    }

    public void clickOnComponents() {
        clickOnElement(componentLink);
        CustomListeners.test.log(Status.PASS, "Click on Components");

    }
    public void clickOnCurrancy() {
        clickOnElement(currancyDropDown);
        CustomListeners.test.log(Status.PASS, "Click on Currancy");
        Reporter.log("Select currancy" + currancyDropDown + "from ram dropdown " + currancyDropDown.toString() + "<br>");
    }
public void mouseHoverOnPoundCurrancy (){
        mouseHoverToElement(poundLink);
    CustomListeners.test.log(Status.PASS, "Click on Pound Currancy");
    Reporter.log("Select pound" + poundLink + "from ram dropdown " + poundLink.toString() + "<br>");
}

    public void clickOnMyAccount() {
        clickOnElement(myAccountLink);
        CustomListeners.test.log(Status.PASS, "click on my accoutn link");
    }

}


