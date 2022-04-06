package Task_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginToAccount {
    private static WebDriver driver;

    public LoginToAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn() {
        driver.findElement(By.name("email")).sendKeys("gzckuetmfoojtgcoqi@kvhrr.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.id("submit-login")).click();
    }
}
