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

public class test1 {

    public static void main( String[] args ) throws InterruptedException
    {
        // System.out.println( "Hello World!" );
        // System.setProperty("webdriver.chrome.driver","C:/SELENIUM/chromedriver.exe");
        // ChromeDriver driver = new ChromeDriver();
        // ChromeOptions ops = new ChromeOptions();
        // ops.addArguments("--remote-allow-origins=*");
        // ChromeDriver driver = new ChromeDriver(ops);

        // EdgeOptions options =  new EdgeOptions();
        // options.addArguments("--remote-allow-origins=*");
        // System.setProperty("webdriver.edgedriver.driver","C:/SELENIUM/edgedriver_win64/msedgedriver.exe");
        // EdgeDriver driver = new EdgeDriver(options);

        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(ops);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));        

        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("user_email_login"))
        );

        WebElement password = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("user_password"))
        );

        // WebElement username=driver.findElement(By.id("user_email_login"));
        // WebElement password=driver.findElement(By.id("user_password"));

        username.sendKeys("abc@gmail.com");
        password.sendKeys("your_password");
        
        Thread.sleep(5000);
        driver.quit();

    }
    
    
}
