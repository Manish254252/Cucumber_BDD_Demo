package com.automation.stepDef;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.test.BaseTest;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyStepDefTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("the user is on Login Page")

    public void if_the_user_is_on_login_page() {

        loginPage.openWebsite();
        Assert.assertTrue(loginPage.isLoginDisplayed());
    }

    @When("User enters user and password and clicks login")

    public void user_enters_user_and_password() {
        loginPage.doLogin(ConfigReader.getConfig("LOGIN.USERNAME"), ConfigReader.getConfig("LOGIN.PASSWORD"));
    }


    @Then("user should go to HomePage")

    public void user_should_go_to_home_page() {

        Assert.assertTrue(homePage.isHamburgerMenuDisplayed());
        Assert.assertTrue(homePage.isAddToCartVisible());

    }

    @Given("the user is on Home Page")

    public void ifTheUserIsOnHomePage() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfig("LOGIN.USERNAME"), ConfigReader.getConfig("LOGIN.PASSWORD"));
        Assert.assertTrue(homePage.isAddToCartVisible());
    }

    @When("User Clicks on logout button")

    public void userClicksOnLogoutButton() {
        Assert.assertTrue(homePage.isAddToCartVisible());
        homePage.clickOnBurgerMenu();
        homePage.clickLogoutMenu();
    }

    @Then("user should go to LoginPage")

    public void userShouldGoToLoginPage() {
        Assert.assertTrue(loginPage.isLoginDisplayed());
    }

    @When("User Clicks on Z-A sort button")
    public void userClicksOnSortButton() throws InterruptedException {
        homePage.reverseSort();
    }

    @Then("list of product should be displayed in descending order")
    public void listOfProductShouldBeDisplayedInDescendingOrder() {
        System.out.println(homePage.listEqual());
    }

    @When("User select High to Low price")
    public void userSelectHighToLowPrice() {
        homePage.selectPriceHighToLow();
        
    }

    @Then("list of product should be displayed in Price High toLow format")
    public void listOfProductShouldBeDisplayedInPriceHighToLowFormat() {
        homePage.checkPriceHighToLow();
    }



}
