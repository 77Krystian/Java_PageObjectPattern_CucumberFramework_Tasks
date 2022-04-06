package Task_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class MyStoreBuyingRunner {
    private static WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void loggingWithOrdering() throws InterruptedException, IOException {
        //Login to account
        LoginToAccount loginToAccount = new LoginToAccount(driver);
        loginToAccount.logIn();

        //Orders product
        ProductOrdering productOrdering = new ProductOrdering(driver);
        productOrdering.orderingProduct();

        //Take screenshot
        productOrdering.takeScreenshot();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
