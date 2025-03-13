package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import java.util.List;

public class ProductsPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(ProductsPage.class);
    @FindBy(css = "[data-test='title']")
    private WebElement productsTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addShirtButton;

    @FindBy(className = "btn_inventory")
    private List<WebElement> itemButtons;

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

    public void clickRandomItemButton(){
        if (itemButtons != null && !itemButtons.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(itemButtons.size());
            itemButtons.get(randomIndex).click();
        } else {
            log.info("No buttons found");
        }
    }
}
