package com.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage {


    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    @FindBy(id = "remove")
    WebElement productRemove;  //remove btn id for product description page


    @FindBys(@FindBy(xpath = "(//div[@class='pricebar']/button)"))
    List<WebElement> addToCartList;


    @FindBys(@FindBy(xpath = "(//div[@class='inventory_item_label']/a)"))
    List<WebElement> items;

    @FindBys(@FindBy(xpath = "(//nav[@class=\"bm-item-list\"]/a)"))
    List<WebElement> burgerMenuItems;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    WebElement addToCartLogo;

    @FindBys(@FindBy(xpath = "(//div[@data-test=\"cart-list\"]/div[@class='cart_item'])"))
    List<WebElement> productListFromCart;

    @FindBy(xpath = "//span[@data-test=\"shopping-cart-badge\"]")
    WebElement cartLogoNumber;

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "first-name")
    WebElement firstname;

    @FindBy(id = "last-name")
    WebElement lastname;

    @FindBy(id = "postal-code")
    WebElement postalcode;

    @FindBy(xpath = "//div[@data-test=\"subtotal-label\"]")
    WebElement subTotal;

    @FindBy(xpath = "//div[@data-test=\"tax-label\"]")
    WebElement tax;

    @FindBy(xpath = "//div[@data-test=\"total-label\"]")
    WebElement Total;

    @FindBy(xpath = "//div[@class=\"error-message-container error\"]")
    WebElement errorMessege;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(xpath = "//h2[@data-test=\"complete-header\"]")
    WebElement successMessege;

    @FindBy(id = "back-to-products")
    WebElement backToHomeBtn;

    @FindBys(@FindBy(xpath = "//div[@data-test=\"inventory-item-name\"]"))
    List<WebElement> productNameList;

    @FindBys(@FindBy(xpath = "//div[@data-test=\"inventory-item-price\"]"))
    List<WebElement> productPriceList;

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    WebElement sortSelector;
    Actions actions =new Actions(driver);
    public void clickOnBurgerMenu() {
        burgerMenu.click();
    }

    public void clickLogoutMenu() {

        logout.click();
    }

    public boolean isHamburgerMenuDisplayed() {
        return burgerMenu.isDisplayed();
    }

    public void addToCart(int a) {
//        System.out.println(addToCartList.size());
//        System.out.println(addToCartList.get(a).getText());
        addToCartList.get(a).click();


    }

    public boolean productDescriptionRemoveIsVisible(int a) {
        items.get(1).click();
        return productRemove.isDisplayed();
    }

    public boolean isBurgerMenuItemsVisible() {
        for (WebElement x : burgerMenuItems) {
            System.out.println(x.getText() + " " + x.isDisplayed());
            if (!x.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void clickAddToCartLogo() {
        addToCartLogo.click();
    }

    public void clickCheckOutBtn() {
        checkOutBtn.click();
    }

    public boolean isAddToCartVisible() {
        return addToCartLogo.isDisplayed();
    }


    public boolean isCheckoutBtnVisible() {
        return checkOutBtn.isDisplayed();
    }

    boolean infoVisible = false;
    public static boolean errorVisibility = false;

    public boolean infoVisibility() {
        return continueBtn.isDisplayed();
    }

    public void addingNullValueOnInformationPage() throws InterruptedException {
//        Assert.assertTrue(errorMessege.isDisplayed());
        firstname.sendKeys("abc");

        continueBtn.click();
        infoVisible = true;
        errorVisibility = errorMessege.isDisplayed();
        Assert.assertTrue(errorMessege.isDisplayed());
        lastname.sendKeys("Abc");
        continueBtn.click();
        errorVisibility = errorMessege.isDisplayed();
        Assert.assertTrue(errorMessege.isDisplayed());
        postalcode.sendKeys("123451");

        Thread.sleep(4000);


    }

    public void clickOnContinueBtnOnInfo() throws InterruptedException {
        actions.pause(5000).build().perform();
        Thread.sleep(3000);
        continueBtn.click();
        Thread.sleep(3000);
    }

    public void clickOnFinishBtn() {
         finishBtn.click();
    }

    public void clickOnBackTOHome() {
        backToHomeBtn.click();
    }

    public void verifyCheckoutProcess() {
        System.out.println(productListFromCart.size());
        System.out.println(cartLogoNumber.getText());
        Assert.assertEquals(productListFromCart.size(), Integer.parseInt(cartLogoNumber.getText()));
        checkOutBtn.click();
        continueBtn.click();
        Assert.assertTrue(errorMessege.isDisplayed());
        firstname.sendKeys("abc");
        continueBtn.click();
        Assert.assertTrue(errorMessege.isDisplayed());
        lastname.sendKeys("Abc");
        continueBtn.click();
        Assert.assertTrue(errorMessege.isDisplayed());
        postalcode.sendKeys("123451");
        continueBtn.click();
        float tax1 = Float.parseFloat(tax.getText().replaceAll("[^0-9.]", ""));

        System.out.println(tax1);
//        System.out.println(tax.getText());
        float subtotal1 = Float.parseFloat(subTotal.getText().replaceAll("[^0-9.]", ""));
        System.out.println(subtotal1);
        float total1 = Float.parseFloat(Total.getText().replaceAll("[^0-9.]", ""));
        System.out.println(total1);
        Assert.assertEquals(total1, tax1 + subtotal1);
        finishBtn.click();
        System.out.println(successMessege.getText());
        backToHomeBtn.click();


    }

    public boolean finishBtnVisible()
    {
       return finishBtn.isDisplayed();
    }

    boolean equals = false;

    public void reverseSort() throws InterruptedException {
        List<String> productListRev = productNameList.stream().map(WebElement::getText).toList().reversed();
        productListRev.forEach(System.out::println);
        Select select = new Select(sortSelector);
        select.selectByIndex(1);
//        Thread.sleep(2000);
        List<String> productList = productNameList.stream().map(WebElement::getText).toList();
        productList.forEach(System.out::println);

        for (int i = 0; i < productListRev.size(); i++) {

            if (!productListRev.get(i).equals(productList.get(i))) {
                System.out.println("Not Equal");
                return;
            }

        }
        System.out.println("Equals");
        equals = true;
    }

    public boolean listEqual() {
        return equals;
    }

    List<Float> productPriceListAfterSort;
    List<Float> productPriceListWithOutSort;

    public void selectPriceHighToLow() {
        Select select = new Select(sortSelector);
        sortSelector.click();
        productPriceListWithOutSort = new ArrayList<>(productPriceList.stream().map(WebElement::getText).map(s -> s.replaceAll("[^0-9.]", "")).map(Float::parseFloat).toList());
        productPriceListWithOutSort.sort((a, b) -> Float.compare(b, a));
        productPriceListWithOutSort.forEach(System.out::println);
        select.selectByIndex(3);
//        Thread.sleep(2000);
        productPriceListAfterSort = productPriceList.stream().map(WebElement::getText).map(s -> s.replaceAll("[^0-9.]", "")).map(Float::parseFloat).toList();
        productPriceListAfterSort.forEach(System.out::println);


    }

    public void checkPriceHighToLow() {
        for (int i = 0; i < productPriceList.size(); i++) {

            if (!Objects.equals(productPriceListWithOutSort.get(i), productPriceListAfterSort.get(i))) {
                System.out.println("Not Equal");
                return;
            }

        }
        System.out.println("Equals");
        equals = true;
    }
}
