package com.narendra.pageobject;

import com.narendra.pageobject.driver.DriverSingleton;
import com.narendra.pageobject.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class TestLogin {


    public static WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("Chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
    }

    @BeforeMethod
    public void pageObject() {
        loginPage = new LoginPage();
    }
    @Test
    public void testLogin() {
        delay(3);
        loginPage.login("Admin","admin1234");
        delay(3);
        assertEquals(loginPage.msgInvalid(), "Invalid credentials");
    }

    @AfterClass
    public void closeBrowser() {
        delay(3);
        driver.quit();
    }

    static void delay(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
