package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class NegativeLogin {
    @Test
    public void NegativeLogin() {

        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        // enter usename
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");
        //enter password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("SuperSecretPassword");
        //click login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();
        //verificare
        WebElement errorAlert = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorAlert.getText().contains("Your password is invalid!"));
    }
}