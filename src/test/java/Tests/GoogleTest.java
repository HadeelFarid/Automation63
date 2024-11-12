package Tests;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTest {
    public static void main(String[] args) {

        WebDriver driver ;

        // 1.Open  Browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to google
        driver .navigate().to("https://www.google.com/");

        // 3. Locating searchBar

        WebElement searchBar = driver.findElement(By.id("APjFqb"));

        // 4. Action -> Type "linkedIn"

        searchBar.sendKeys("LinkedIn");

        // 5.Click on Enter
        searchBar.sendKeys(Keys.ENTER);

        // 6. Close Browser
        driver.close();







    }
}
