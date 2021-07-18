package com.herokuappinternet;


import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test(enabled = true)
public class Login {

    ChromeDriver mDriver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/home/nastia/Downloads/chromedriver_linux64/chromedriver");

        mDriver = new ChromeDriver();
        mDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        mDriver.get("https://the-internet.herokuapp.com/login");
    }


    @Test
    public void login() {

        Timeout.millis(2000);

        mDriver.findElement(By.id("username")).sendKeys("tomsmith");
        mDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        mDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
        Timeout.millis(1000);
        mDriver.findElement(By.className("button")).click();

    }

    @Test
    public void loginError(){
        Timeout.millis(1000);

        mDriver.findElement(By.id("username")).sendKeys("");
        mDriver.findElement(By.id("password")).sendKeys("");
        mDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
        Assert.assertTrue(mDriver.findElement(By.id("flash")).isDisplayed());
        mDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
    }

    @Test
    public void passwordError() {
        Timeout.millis(1000);

        mDriver.findElement(By.id("username")).sendKeys("tomsmith");
        mDriver.findElement(By.id("password")).sendKeys("");
        mDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
        Assert.assertTrue(mDriver.findElement(By.id("flash")).isDisplayed());
        mDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
    }

        @Test
        public void usernameError() {
            Timeout.millis(1000);

            mDriver.findElement(By.id("username")).sendKeys("");
            mDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            mDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
            Assert.assertTrue(mDriver.findElement(By.id("flash")).isDisplayed());
            mDriver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
        }

    @AfterMethod
    public void after() {
        mDriver.quit();
    }
}
