package com.narendra.pageobject.main;

import com.narendra.pageobject.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class MainApp {

    public static void main(String[] args) {
        DriverSingleton.getInstance("Chrome");
        WebDriver driver = DriverSingleton.getDriver();
        String url = "";
        driver.get(url);

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
