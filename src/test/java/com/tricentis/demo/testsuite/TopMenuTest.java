package com.tricentis.demo.testsuite;

import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.pages.ComponentsPage;
import com.tricentis.demo.pages.DesktopsPage;
import com.tricentis.demo.pages.HomePage;
import com.tricentis.demo.pages.LaptopsAndNotebooksPage;
import com.tricentis.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */


@Listeners(CustomListeners.class)

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
//       1.1 Mouse hover on “Desktops”Tab and click 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.clickOnDesktop();
        // 1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");
//       1.3 Verify the text ‘Desktops’
        desktopsPage.desktopText();

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
//   2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooks();
//   2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
//   2.3 Verify the text ‘Laptops & Notebooks’
        laptopsAndNotebooksPage.verifyLaptopAndNotebooksText();
//
    }
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
//        3.1 Mouse hover on “Components”Tab and click
        homePage.clickOnComponents();
//        3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show AllComponents");
//        3.3 Verify the text ‘Components’
        componentsPage.componentText();


    }
}