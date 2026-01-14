package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Login page element holder.
 * - Contains ONLY locators + wait logic
 * - Keeps tests DRY
 */
public class loginLocators {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // ===== Locators =====
    private final By usernameInput = By.id("user_email_login");
    private final By passwordInput = By.id("user_password");

    // ===== Constructor =====
    public loginLocators(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== Element getters =====
    public WebElement username() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(usernameInput)
        );
    }

    public WebElement password() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordInput)
        );
    }
}
