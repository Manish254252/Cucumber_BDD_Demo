package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginbtn;


    public void openWebsite() {

        driver.get("https://www.saucedemo.com/");
    }

    public void doLogin(String username, String password1) {
        userName.sendKeys(username);
        password.sendKeys(password1);
        loginbtn.click();
    }

    public boolean isLoginDisplayed() {
        return userName.isDisplayed() && password.isDisplayed();
    }


}
