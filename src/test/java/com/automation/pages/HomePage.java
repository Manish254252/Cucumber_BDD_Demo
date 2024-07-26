package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
//import org.testng.Assert;

import java.util.List;

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
        System.out.println(addToCartList.size());
        System.out.println(addToCartList.get(0).getText());
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

    public boolean isAddToCartVisible() {
        return addToCartLogo.isDisplayed();
    }

   public  void verifyCheckoutProcess() {
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
        float tax1 = Float.parseFloat(tax.getText().replaceAll("[^0-9.]",""));

       System.out.println(tax1);
//        System.out.println(tax.getText());
        float subtotal1 = Float.parseFloat(subTotal.getText().replaceAll("[^0-9.]",""));
        System.out.println(subtotal1);
       float total1 = Float.parseFloat(Total.getText().replaceAll("[^0-9.]",""));
        System.out.println(total1);
        Assert.assertEquals(total1,tax1+subtotal1);
        finishBtn.click();
        System.out.println(successMessege.getText());
        backToHomeBtn.click();


    }
}
