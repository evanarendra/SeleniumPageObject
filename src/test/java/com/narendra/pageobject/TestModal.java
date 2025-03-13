package com.narendra.pageobject;

import com.narendra.pageobject.driver.DriverSingleton;
import com.narendra.pageobject.pages.Modal;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestModal {

    public static WebDriver driver;
    private Modal modal;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("Chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://demoqa.com/modal-dialogs";
        driver.get(url);
    }

    @BeforeMethod
    public void pageObject() {
        modal = new Modal();
    }

    @Test
    public void testShowModal() {
        delay(2);
//        js.executeScript("window.scrollBy(0,700)", "");
        modal.clickSmallModal();
        delay(2);
        System.out.println(modal.getTitleModal());
        System.out.println(modal.getBodyModal());
    }

    static void delay(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
