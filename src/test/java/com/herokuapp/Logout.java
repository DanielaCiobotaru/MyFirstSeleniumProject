package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout {
    @Test
    public void logoutTest(){
        //open
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        //login
        WebElement usernameInput= driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");
        //logout
        //enter password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("SuperSecretPassword!");
        //verify successfull logout
        //click login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();
        //click logout
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        logoutButton.click();
        WebElement logoutMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String text = "You logged out of the secure area!";
        Assert.assertTrue(logoutMessage.getText().contains(text));
        //close page
    }
}