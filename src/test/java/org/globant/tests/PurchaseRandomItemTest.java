package org.globant.tests;
import org.globant.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PurchaseRandomItemTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(PurchaseRandomItemTest.class);

    @DataProvider(name = "Data to test complete purchase")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", "Test", "User", "202012"}
        };
    }

    @Test(testName = "Successful clear cart", dataProvider = "Data to test complete purchase")
    public void successfulClearCart(String username, String password, String firstname, String lastname, String postalCode){
        //First we have to log in
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        ProductsPage productsPage = loginPage.clickLoginButton();
        //Now we add a random item to the cart
        productsPage.clickRandomItemButton();
        //If the cart badge is visible, it means the product was added to the cart.
        //Otherwise, something went wrong adding it
        if(topBar.isCartBadgeDisplayed()) {
            //Then we click the cart button
            CartPage cartPage = topBar.clickCartButton();
            //Then we click the checkout button in the Cart Page
            CheckoutStepOnePage checkoutStepOnePage = cartPage.clickCheckoutButton();
            //Then we enter the required data in the step one of the checkout
            checkoutStepOnePage.enterFirstname(firstname);
            checkoutStepOnePage.enterLastname(lastname);
            checkoutStepOnePage.enterPostalCode(postalCode);
            //Then we click the Continue button
            CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.clickContinueButton();
            //Then we click the Finish button in the step two of the checkout
            CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickFinishButton();
            //Now we should be in the completed checkout page, we assert this by verifying
            //the visilibity of the completed checkout header
            Assert.assertTrue(checkoutCompletePage.isCompleteHeaderVisible());
        }else{
            //The badge is not visible, so something went wrong adding the product
            log.info("Product was not added");
            Assert.fail();
        }
    }
}
