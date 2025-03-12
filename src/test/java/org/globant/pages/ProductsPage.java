package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {

    @FindBy(css = "[data-test='title']")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addShirtButton;

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public void clickAddBackpackButton(){
        addBackpackButton.click();
    }

    public void clickAddBikeButton(){
        addBikeButton.click();
    }

    public void clickAddShirtButton(){
        addShirtButton.click();
    }
}
