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
public class Checkbox {

    ChromeDriver mDriver;

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/home/nastia/Downloads/chromedriver_linux64/chromedriver");

        mDriver = new ChromeDriver();
        mDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        mDriver.get("https://the-internet.herokuapp.com/checkboxes");

    }
    @Test
    public void checkbox() {

        Timeout.millis(2000);
        mDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
        Assert.assertTrue(mDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected());

        Timeout.millis(2000);
        mDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        Assert.assertTrue(mDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected());
    }

    @AfterMethod
    public void after() {
        mDriver.quit();
    }
}


