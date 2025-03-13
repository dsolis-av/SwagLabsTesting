package org.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement firstnameField;

    @FindBy(id = "last-name")
    private WebElement lastnameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver){
        super(driver);
    }

    public void enterFirstname(String firstname){
        firstnameField.sendKeys(firstname);
    }

    public void enterLastname(String lastname){
        lastnameField.sendKeys(lastname);
    }

    public void enterPostalCode(String postalCode){
        postalCodeField.sendKeys(postalCode);
    }

    public CheckoutStepTwoPage clickContinueButton(){
        continueButton.click();
        return new CheckoutStepTwoPage(driver);
    }
}
