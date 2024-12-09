package com.tricentis.demo.testsuite;

import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.pages.*;
import com.tricentis.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Listeners(CustomListeners.class)
public class DesktopsTest extends BaseTest {

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();
    ProductPage productPage = new ProductPage();
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"sanity"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
//        1.1 Mouse hover on Desktops Tab.and click
        homePage.clickOnDesktop();
//        1.2 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");
//        1.3 Select Sort By position "Name: Z to A"

        List<WebElement> products1 = getListOfElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products1) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
//        Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        desktopsPage.selectSortByPostionZtoA("Name (Z - A)");
//        1.4 Verify the Product will arrange in Descending order.
        List<WebElement> products = getListOfElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product is not sorted");

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total) {
//        2.1 Mouse hover on Currency Dropdown and click
           homePage.clickOnCurrancy();

//           2.2 Mouse hover on £Pound Sterling and click
          homePage.mouseHoverOnPoundCurrancy();
//            2.3 Mouse hover on Desktops Tab.
              homePage.clickOnDesktop();
//            2.4 Click on “Show All Desktops”
              homePage.selectMenu("Show AllDesktops");
//            2.5 Select Sort By position "Name: A to Z"
              desktopsPage.selectSortByPostionAtoZ("Name (A - Z)");
//            2.6 Select product <product>
              desktopsPage.clickOnHTCtouchHD(product);
//             2.7 Enter Qty <qty> using Select class.
               productPage.setChangeqty(qty);
//            2.8 Click on “Add to Cart” button
               productPage.clickOnAddToCart();
//            2.9 Verify the Message <successMessage>
productPage.veridySuccessText();
//             2.10 Click on link “shopping cart” display into success message
       productPage.setClickOnShoppingCart();
//             2.11 Verify the text "Shopping Cart"
productPage.shoppingcarttext();
//            2.12 Verify the Product name <productName>

//            2.13 Verify the Model <model>

//          2.14 Verify the Total <total>
    }
}