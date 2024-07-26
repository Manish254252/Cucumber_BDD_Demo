package com.automation.test;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;


public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;


    @BeforeMethod(alwaysRun = true)
    protected void setUp() throws IOException {
        ConfigReader.initConfig();
        DriverManager.createDriver();
        driver = DriverManager.getDriver();
        loginPage = new LoginPage();
        homePage = new HomePage();


    }

    @AfterMethod(alwaysRun = true)
    protected void cleanUp() {

        driver.quit();
    }
}
