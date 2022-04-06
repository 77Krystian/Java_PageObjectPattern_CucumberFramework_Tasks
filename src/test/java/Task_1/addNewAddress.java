package Task_1;

import com.google.common.collect.Table;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.DataTable;
import io.cucumber.messages.types.Examples;
import io.cucumber.messages.types.TableCell;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addNewAddress {

    private WebDriver driver;

    @Given("I have open browser with with login page on my-store")
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("I enter data and click SignIn button")
    public void loginToAccount() {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("gzckuetmfoojtgcoqi@kvhrr.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("password123");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @And("I click on add first address")
    public void clickAddFirstAddres() {
        driver.findElement(By.xpath("//a[@id='address-link']")).click();
    }

    @And("^I enter data and click save button(.*), (.*), (.*), (.*), (.*), (.*)$")
    public void enterDataAndSubmit(String alias, String address, String postal, String city, String country, String phone) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.click();
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.click();
        addressInput.sendKeys(address);

        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        postcodeInput.click();
        postcodeInput.sendKeys(postal);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.click();
        cityInput.sendKeys(city);


        WebElement countryInput = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]"));
        countryInput.click();

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.click();
        phoneInput.sendKeys(phone);

        driver.findElement(By.className("btn")).click();

        WebElement dataAlert = driver.findElement(By.xpath("//article[@data-alert='success']"));
        if (dataAlert.isDisplayed()) {
            System.out.println("Address added successful");
        } else {
            System.out.println("Address added failed");
        }
    }

    @Then("I added address to my account")
    public void closeBrowser() {
        driver.quit();
    }
}
