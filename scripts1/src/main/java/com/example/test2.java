package com.example;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class test2 {

    public static void main( String[] args ) throws InterruptedException
    {
        long startTime = System.currentTimeMillis();
        System.out.println("[login1] START - Chrome");

        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(ops);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            System.out.println("[login1] Maximizing window");
            driver.manage().window().maximize();

            System.out.println("[login1] Navigating to BrowserStack login page");
            driver.get("https://www.browserstack.com/users/sign_in");

            System.out.println("[login1] Waiting for login form");
            WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user_email_login"))
            );

            WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))
            );

            System.out.println("[login1] Entering username");
            username.sendKeys("abc@gmail.com");

            System.out.println("[login1] Entering password (masked)");
            password.sendKeys("your_password");

            System.out.println("[login1] Login inputs completed");

        } catch (Exception e) {
            System.out.println("[login1] ERROR: " + e.getMessage());
            System.out.println("[login1] URL at failure: " + driver.getCurrentUrl());
            System.out.println("[login1] Title at failure: " + driver.getTitle());
            e.printStackTrace();

        } finally {
            System.out.println("[login1] Quitting driver");
            driver.quit();

            long duration = System.currentTimeMillis() - startTime;
            System.out.println("[login1] END - Duration: " + duration + " ms");
        }

        }
    
    
}
