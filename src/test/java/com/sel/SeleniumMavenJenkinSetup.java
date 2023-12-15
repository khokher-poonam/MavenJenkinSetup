package com.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumMavenJenkinSetup {
    WebDriver driver;

    @BeforeSuite
    public void launchBrowser() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        //driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    }
    @Test
    public void verifyTitle() {

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Google";
        Assert.assertEquals(ActualTitle, ExpectedTitle);
        System.out.println("The title is:Google");

    }
    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
