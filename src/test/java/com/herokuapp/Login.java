package com.herokuapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Login {
    @Test
    public void loginTest(){
        //open page
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        // enter usename
        WebElement usernameInput= driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");
//enter password
WebElement passwordInput = driver.findElement(By.name("password"));
passwordInput.sendKeys("SuperSecretPassword!");
//click login
WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
loginButton.click();
//WebElement loginButton = driver.findElement(By.LinkText("Login"));

        String secureUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(secureUrl, driver.getCurrentUrl());
        String successMessage = "You logged into a secure area!";
        WebElement successAlert = driver.findElement(By.id("flash"));
        successAlert.getText();
        Assert.assertTrue( successAlert.getText().contains(successMessage));
        WebElement logoutButton = driver.findElement( By.className("icon-signout"));
        Assert.assertTrue(logoutButton.isDisplayed());
        //close driver
        driver.close();

            }
            }









