package com.narendra.pageobject;

import com.narendra.pageobject.driver.DriverSingleton;
import com.narendra.pageobject.pages.LoginPage;
import com.narendra.pageobject.pages.LoginSiloam;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class TestLoginSiloam {

    public static WebDriver driver;
    private LoginSiloam loginSiloam;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("Chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://dev.ptdika.com/siloam/panel/login";
        driver.get(url);
    }

    @BeforeMethod
    public void pageObject() {
        loginSiloam = new LoginSiloam();
    }
    @Test
    public void testInvalidLogin() {
        delay(3);
        loginSiloam.login("Admin","admin1234");
        delay(3);
        System.out.println(loginSiloam.getAttributeRequired());
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
