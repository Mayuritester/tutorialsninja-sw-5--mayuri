package com.tricentis.demo.testsuite;

import com.tricentis.demo.pages.*;
import com.tricentis.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ComponentsPage componentsPage = new ComponentsPage();
    ProductPage productPage = new ProductPage();
    MacbookPage macbookPage = new MacbookPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopsPage = new DesktopsPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
        productPage = new ProductPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();

    }


    @Test(groups = {"sanity"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
//1.1 Click on My Account Link.
        homePage.clickOnMyAccount();
//1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMenu("Register");
// 1.3 Verify the text “Register Account”.
        registerPage.verifyRegisterText();
    }

    @Test(groups = {"smoke", "regression"})

    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
//2.1 Clickr on My Account Link.
        homePage.clickOnMyAccount();
//2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMenu("Login");
// 2.3 Verify the text “Returning Customer”.
        loginPage.verifyreturnText();

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {
//3.1 Clickr on My Account Link
        homePage.clickOnMyAccount();
//3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMenu("Register");
// 3.3 Enter First Name
        registerPage.enterFirstName("Payal");
//3.4 Enter Last Name
        registerPage.enterLastName("Patel");
//3.5 Enter Email
        registerPage.enterEmail("dancer123@gmail.com");
//3.6 Enter Telephone
        registerPage.entertelehpone("07751316061");
//3.7 Enter Password
        registerPage.enterPassword("Prime123");
//3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("Prime123");
//3.9 Select Subscribe Yes radio button
        registerPage.radioYes();
//3.10 Click on Privacy Policy check box
        registerPage.tickPolicyBox();
//3.11 Click on Continue button
        registerPage.clickContinue();
// 3.12 Verify the message “Your Account Has Been Created!”
        myAccountPage.setVerifyYourAccountHasBeenCreatedText();
// 3.13 Click on Continue button
        myAccountPage.clickContinue();
// 3.14 Click on My Account Link.
        homePage.clickOnMyAccount();
//3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMenu("Logout");
// 3.16 Verify the text “Account Logout”
        myAccountPage.setVerifyLogOutText();
//3.17 Click on Continue button
        myAccountPage.clickContinue1();
    }
    @Test(groups = { "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
//        4.1 Clickr on My Account Link.
        homePage.clickOnMyAccount();
//        4.2 Call the method “selectMyAccountOptions”method and pass the parameter “Login”
        homePage.selectMenu("Login");
//        4.3 Enter Email address
         loginPage.enterEmailId("dancer123@gmail.com");

//        4.5 Enter Password
          loginPage.enterPassword("prime123");
//        4.6 Click on Login button
          loginPage.clickOnLoginButton();
//        4.7 Verify text “My Account”

//        4.8 Clickr on My Account Link.
        homePage.clickOnMyAccount();
//        4.9 Call the method “selectMyAccountOptions”method and pass the parameter “Logout”
       homePage.selectMenu("Logout");
//        4.10 Verify the text “Account Logout”
        myAccountPage.setVerifyLogOutText();
//        4.11 Click on Continue button
        myAccountPage.clickContinue1();
    }
}
