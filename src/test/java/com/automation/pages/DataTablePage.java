package com.automation.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DataTablePage extends BasePage {
    @FindBy(xpath = "//table[@id=\"example\"]/tbody/tr")
    List<WebElement> tableData;

    public void openWebsite() {
        driver.get("https://datatables.net/");
    }

    public boolean verifyData(List<List<String>> table) {

        for (int i = 0; i < table.size(); i++) {
//            String row = table.get(i).toString().replaceAll("[^a-zA-Z0-9/\\s()-]", "");
            String row = table.get(i).toString().replaceAll("[\\[\\],]", "");

            List<String> results = tableData.stream().map(WebElement::getText).toList();
            if (!results.get(i).equals(row)) {

                return false;
            }

        }

        return true;


    }
}
