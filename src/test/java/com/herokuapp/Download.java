package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Download {
    @Test
    public void downloadTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/download";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement fileEx = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]"));
        fileEx.click();
        driver.close();


    }
}
