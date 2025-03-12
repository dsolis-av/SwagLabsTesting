package org.globant.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.globant.pages.LoginPage;
import org.globant.pages.TopBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{


    @DataProvider(name = "Login data to test logout")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(testName = "Successful logout", dataProvider = "Login data to test logout")
    public void successfulLogin(String username, String password){
        //First we have to log in
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        //Now we interact with the burguer button in the top bar
        topBar.clickBurguerButton();
        //Click the logout button
        topBar.clickLogoutButton();
        //Assert the visibility of the username field. If it is visible, it means we are in the login page
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed());
    }

}
