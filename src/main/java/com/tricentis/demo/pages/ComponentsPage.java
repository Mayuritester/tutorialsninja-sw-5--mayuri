package com.tricentis.demo.pages;

import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement componentsText ;


    public String componentText (){
        getTextFromElement(componentsText);
        String message = getTextFromElement(componentsText);
        return message;

    }
}
