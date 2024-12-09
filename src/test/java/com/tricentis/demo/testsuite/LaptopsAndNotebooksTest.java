package com.tricentis.demo.testsuite;

import com.tricentis.demo.pages.*;
import com.tricentis.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();
    ProductPage productPage = new ProductPage();
    MacbookPage macbookPage = new MacbookPage();
    RegisterPage registerPage = new RegisterPage();
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
        productPage = new ProductPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
//            1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
//            1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
//            1.3 Select Sort By "Price (High > Low)"
        List<WebElement> products = getListOfElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        laptopsAndNotebooksPage.selectSortByPriceHighTOlow("Price (High > Low)");
//
//            1.4 Verify the Product price will arrange in High to Low order.
        products = getListOfElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);

        Assert.assertEquals(afterSortByPrice, originalProductsPrice, "Not sorted High too low");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
//2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
//2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
//            2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.selectSortByPriceHighTOlow("Price (High > Low)");
//            2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.setClickOnMacBook();
//            2.5 Verify the text “MacBook”
        laptopsAndNotebooksPage.verifyMacbook();
//            2.6 Click on ‘Add To Cart’ button
        productPage.clickOnAddToCart();
//            2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        productPage.veridySuccessText();
//            2.8 Click on link “shopping cart” display into success message
        productPage.setClickOnShoppingCart();
//2.9 Verify the text "Shopping Cart"
        productPage.shoppingcarttext();
//            2.10 Verify the Product name "MacBook"
        laptopsAndNotebooksPage.verifyMacbook();
//            2.11 Change Quantity "2"
        macbookPage.enterQTY();
//            2.12 Click on “Update” Tab
        macbookPage.clickupdate();
//            2.13 Verify the message “Success: You have modified your shopping cart!”
        macbookPage.verifyUpdate();
//            2.14 Verify the Total £737.45
        macbookPage.clickupdate();
//            2.15 Click on “Checkout” button
        macbookPage.verifyTotal();

    }



}
