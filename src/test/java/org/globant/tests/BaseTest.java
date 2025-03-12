package org.globant.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.globant.pages.LoginPage;
import org.globant.pages.TopBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected TopBar topBar;
    private static final String BASE_URL = "https://www.saucedemo.com";

    //In every test we have to comply this preconditions. Every test starts at the base page
    //which is the login page. This is because authentication is needed to perform all of the
    //test actions and to access all of the tested pages
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        topBar = new TopBar(driver);
    }
}
