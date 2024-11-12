package Tests;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    WebDriver driver ;
    LoginPage loginPage ;
    @BeforeMethod
    public void preconditions()
    {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        loginPage  = new LoginPage(driver);
    }


    @Test(priority = 0)
    public void validlogin()

    {

        loginPage.username_TextBox().sendKeys("tomsmith");
        loginPage.password_TextBox().sendKeys("SuperSecretPassword!");
        loginPage.login_Button().click();

        Assert.assertTrue( driver.findElement(By.className("subheader")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.className("subheader")).getText(),"Welcome to the Secure Area. When you are done click logout below.");

        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));

        driver.quit();

    }

    @Test(priority = 1)
    public void invalidUsername()
    {


        loginPage.username_TextBox().sendKeys("invalid");
        loginPage.password_TextBox().sendKeys("SuperSecretPassword!");
        loginPage.login_Button().click();


        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("Your username is invalid!"));

    }


    @Test(priority = 2)
    public void invalidPassword()
    {


    loginPage.username_TextBox().sendKeys("tomsmith");
        loginPage.password_TextBox().sendKeys("invalid");
        loginPage.login_Button().click();



        Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("Your password is invalid!"));
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }hadeel write


}



