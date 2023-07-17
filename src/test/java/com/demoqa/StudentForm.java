package com.demoqa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StudentForm {
    @Test
    public void studentFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    String url = "https://demoqa.com/automation-practice-form";
    driver.get(url);
    driver.manage().window().maximize();
        WebElement nameInput = driver.findElement(By.id("firstName"));
        nameInput.sendKeys("Maricica");
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Popescu");
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("papushika@yahoo.com");
        WebElement genderInput = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label"));
        genderInput.click();
        WebElement telInput = driver.findElement(By.id("userNumber"));
        telInput.sendKeys("alinaaremere");
    }
}
