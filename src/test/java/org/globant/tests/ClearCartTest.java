package org.globant.tests;

import org.globant.pages.CartPage;
import org.globant.pages.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClearCartTest extends BaseTest{


    @DataProvider(name = "Login data to test clear cart")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(testName = "Successful clear cart", dataProvider = "Login data to test clear cart")
    public void successfulClearCart(String username, String password){
        //First we have to log in
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        ProductsPage productsPage = loginPage.clickLoginButton();
        //Now we click the buttons to add products
        productsPage.clickAddBackpackButton();
        productsPage.clickAddBikeButton();
        productsPage.clickAddShirtButton();
        //If the cart badge is visible, it means the products were added to the cart.
        //Otherwise, something went wrong adding them
        if(topBar.isCartBadgeDisplayed()){
            //Now we go to cart page
            CartPage cartPage = topBar.clickCartButton();
            //Now we remove all the added items
            cartPage.clickRemoveBackpackButton();
            cartPage.clickRemoveBikeButton();
            cartPage.clickRemoveShirtButton();
            //At this point, the badge should no longer be visible. This means
            //there's no items in the cart anymore, which means it's now empty
            Assert.assertFalse(topBar.isCartBadgeDisplayed());
        }else{
            //The badge is not visible, so something went wrong adding the products
            Assert.fail();
        }


    }

}
