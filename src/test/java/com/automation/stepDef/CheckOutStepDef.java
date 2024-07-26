package com.automation.stepDef;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckOutStepDef {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @Given("User adds items to the cart")
    public void userAddsItemsToTheCart() {
//        loginPage.openWebsite();
//        loginPage.doLogin("standard_user","secret_sauce");
        homePage.addToCart(1);
        homePage.addToCart(2);
        homePage.addToCart(3);
    }

    @When("User clicks on the cart logo")
    public void userClicksOnTheCartLogo() {
        homePage.clickAddToCartLogo();
    }

    @Then("The cart page should be displayed")
    public void theCartPageShouldBeDisplayed() {
        Assert.assertTrue( homePage.isCheckoutBtnVisible());
    }

    @When("User clicks on the Checkout button")
    public void userClicksOnTheCheckoutButton() {
        homePage.clickCheckOutBtn();
    }

    @Then("User should be navigated to the information page")
    public void userShouldBeNavigatedToTheInformationPage() {
        Assert.assertTrue(homePage.infoVisibility());
    }

    @When("User provides null value for any field")
    public void userProvidesNullValueForAnyField() throws InterruptedException {
        homePage.addingNullValueOnInformationPage();
        Thread.sleep(3000);
    }

    @Then("An error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
       Assert.assertTrue( HomePage.errorVisibility);
    }

    @When("User clicks on the Continue button")
    public void userClicksOnTheContinueButton() throws InterruptedException {
        homePage.clickOnContinueBtnOnInfo();
    }

    @Then("User should be navigated to the checkout page")

    public void userShouldBeNavigatedToTheCheckoutPage() {
       Assert.assertTrue(homePage.finishBtnVisible());
    }

    @When("User clicks on the Finish button")
    public void userClicksOnTheFinishButton() {
        homePage.clickOnFinishBtn();
    }

    @Then("An order successful message should be visible")
    public void anOrderSuccessfulMessageShouldBeVisible() {
        homePage.clickOnBackTOHome();
    }
}
