package com.tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.loginLocators;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login2 {
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(ops);

        loginLocators login = new loginLocators(driver);

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));        

        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/users/sign_in");
        try {
            // WebElement xxx = wait.until(
            //     ExplectedConditions.visibilityOfElementLocated(By.id("user_xxx_login"))
            // );

            // WebElement xxx=driver.findElement(By.id("user_xxx_login"));

            // xxx.sendKeys("abc@gmail.com");

            login.username().sendKeys("abc@gmail.com");
            login.password().sendKeys("your_password");

        } catch (Exception e) {
            System.out.println("[login1] ERROR: " + e.getMessage());
            System.out.println("[login1] URL at failure: " + driver.getCurrentUrl());
            System.out.println("[login1] Title at failure: " + driver.getTitle());
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
        
        
    }
    
}
