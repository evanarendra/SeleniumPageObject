package com.narendra.pageobject.pages;

import com.narendra.pageobject.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RandomPokemon {
    private WebDriver driver;

    public RandomPokemon() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='n']")
    private WebElement selectAmount;

    @FindBy(xpath = "//input[@value='Generate']")
    private WebElement btnGenerate;

    public void generatePokemon() {
        Select select = new Select(selectAmount);
        select.selectByValue("4");
        btnGenerate.click();
    }
}
