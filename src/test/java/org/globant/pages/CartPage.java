package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeBikeButton;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    private WebElement removeShirtButton;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void clickRemoveBackpackButton(){
        removeBackpackButton.click();
    }

    public void clickRemoveBikeButton(){
        removeBikeButton.click();
    }

    public void clickRemoveShirtButton(){
        removeShirtButton.click();
    }

}
