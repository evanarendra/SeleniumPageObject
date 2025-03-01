package com.narendra.pageobject.drivers.strategies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{

    public WebDriver setStrategy() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
