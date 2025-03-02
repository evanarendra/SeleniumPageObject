package com.narendra.pageobject.main;

import com.narendra.pageobject.driver.DriverSingleton;
import com.narendra.pageobject.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class MainApp {

    public static void main(String[] args) {
        DriverSingleton.getInstance("Chrome");
        WebDriver driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);

        delay(3);

        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin","admin123");
        delay(3);

//      driver.quit();
    }

    static void delay(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
