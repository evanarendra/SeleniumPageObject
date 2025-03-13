package com.narendra.pageobject;

import com.narendra.pageobject.driver.DriverSingleton;
import com.narendra.pageobject.pages.LoginPage;
import com.narendra.pageobject.pages.SampleFrame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class TestFrame {

    public static WebDriver driver;
    private SampleFrame sampleFrame;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("Chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://demoqa.com/frames";
        driver.get(url);
    }

    @BeforeMethod
    public void pageObject() {
        sampleFrame = new SampleFrame();
    }

    @Test
    public void testFrame() {
        System.out.println(sampleFrame.getTxtOutFrame());
        System.out.println(sampleFrame.getTxtFrame());
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
