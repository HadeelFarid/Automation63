package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    WebDriver driver ;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement username_TextBox()
    {
        return driver.findElement(By.id("username"));
    }

    public WebElement password_TextBox()
    {
        return driver.findElement(By.id("password"));

    }
    public WebElement login_Button()
    {
        return driver.findElement(By.xpath("//button[@type='submit']"));

    }
}

