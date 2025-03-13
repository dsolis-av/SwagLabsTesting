package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BasePage{

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver){
        super(driver);
    }

    public CheckoutCompletePage clickFinishButton(){
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
