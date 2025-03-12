package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopBar  extends BasePage {

    private static final int TIMEOUT=10;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burguerButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    public TopBar(WebDriver driver){
        super(driver);
    }

    public void clickBurguerButton(){
        burguerButton.click();
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
    }

    public LoginPage clickLogoutButton(){
        logoutButton.click();
        return new LoginPage(driver);
    }

    public CartPage clickCartButton(){
        cartButton.click();
        return new CartPage(driver);
    }

    public boolean isCartBadgeDisplayed(){
        return cartBadge.isDisplayed();
    }
}
