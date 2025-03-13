package com.narendra.pageobject;

import com.narendra.pageobject.driver.DriverSingleton;
import com.narendra.pageobject.pages.RandomPokemon;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRandomPokemon {

    public static WebDriver driver;
    private RandomPokemon randomPokemon;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("Chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://randompokemon.com/";
        driver.get(url);
    }

    @BeforeMethod
    public void pageObject() {
        randomPokemon = new RandomPokemon();
    }

    @Test
    public void testGeneratePokemo() {
        delay(2);
        randomPokemon.generatePokemon();
    }

    static void delay(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
