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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test3_parabankLoginTransfer {

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

            System.out.println("[login1] Navigating to Parabank login page");
            driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");

            System.out.println("[login1] Waiting for login form");
            WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
            );

            WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("password"))
            );

            WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Log In']"))
            );

            System.out.println("[login1] Entering username");
            username.sendKeys("kaungpyae");

            System.out.println("[login1] Entering password (masked)");
            password.sendKeys("kpdnlh!1");

            System.out.println("[login1] Clicking login button");
            loginButton.click();

            System.out.println("[login1] Login inputs completed");

            WebElement openNewAccount = wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Open New Account"))
            );

            System.out.println("[login1] Clicking Open New Account link");
            openNewAccount.click();

            System.out.println("[login1] Waiting for account dropdowns");
            WebElement typeAccountDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("type"))
            );

            System.out.println("[login1] Selecting account type: SAVINGS");
            new Select(typeAccountDropdown).selectByVisibleText("SAVINGS");

            WebElement fromAccountDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("fromAccountId"))
            );

            // Thread.sleep(5000);
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("#fromAccountId option"), 0));

            System.out.println("[login1] Selecting from account (first available)");
            new Select(fromAccountDropdown).selectByIndex(0);

            WebElement submitNewAccount = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Open New Account']"))
            );

            System.out.println("[login1] Submitting new account request");
            submitNewAccount.click();

            System.out.println("[login1] Waiting for confirmation");
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rightPanel"))
            ));
            WebElement newAccountId = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("newAccountId"))
            );

            String accountNumber = newAccountId.getText();

            System.out.println("[login1] New account created: " + accountNumber);
            System.out.println("[login1] New account opened successfully");


        } catch (Exception e) {
            System.out.println("[login1] ERROR: " + e.getMessage());
            System.out.println("[login1] URL at failure: " + driver.getCurrentUrl());
            System.out.println("[login1] Title at failure: " + driver.getTitle());
            e.printStackTrace();

        } finally {
            System.out.println("[login1] Current URL: " + driver.getCurrentUrl());
            System.out.println("[login1] Quitting driver");
            driver.quit();

            long duration = System.currentTimeMillis() - startTime;
            System.out.println("[login1] END - Duration: " + duration + " ms");
        }

        }
    
    
}
