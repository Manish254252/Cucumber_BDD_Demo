package com.automation.stepDef;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.test.BaseTest;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks extends BaseTest {


    @Before
    public void setUp() throws IOException {
          super.setUp();
    }

    @After
    public void tearDown() {

        super.cleanUp();
    }
}
