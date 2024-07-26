package com.automation.stepDef;

import com.automation.pages.DataTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class DataStep {

    DataTablePage dataTablePage = new DataTablePage();
    @Given("User opens table data website")
    public void userOpensTableDataWebsite() {
        dataTablePage.openWebsite();
    }

    @Then("Verify this data is present on the website")
    public void verifyThisDataIsPresentOnTheWebsite(List<List<String>> table) {
       Assert.assertTrue( dataTablePage.verifyData(table));

    }
}
