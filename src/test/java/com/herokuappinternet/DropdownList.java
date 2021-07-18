package com.herokuappinternet;

import org.junit.Assert;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;


@Test(enabled = true)
public class DropdownList {

    ChromeDriver mDriver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/home/nastia/Downloads/chromedriver_linux64/chromedriver");

        mDriver = new ChromeDriver();
        mDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mDriver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void dropdown() {

        Timeout.millis(1000);
        mDriver.findElement(By.id("dropdown")).click();
        Timeout.millis(5000);
        mDriver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[2]")).click();
        Timeout.millis(5000);
        mDriver.findElement(By.id("dropdown")).click();
        Timeout.millis(5000);
        mDriver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).click();
    }

    @AfterMethod
    public void after() {
       mDriver.quit();
    }
}