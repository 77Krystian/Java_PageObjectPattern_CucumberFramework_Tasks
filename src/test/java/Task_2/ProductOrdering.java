package Task_2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ProductOrdering {

    private static WebDriver driver;

    public ProductOrdering(WebDriver driver) {
        this.driver = driver;
    }


    public void orderingProduct() throws InterruptedException {
        //Back to homepage and pick a product
        driver.findElement(By.className("logo")).click();
        driver.findElement(By.xpath("//img[@src='https://mystore-testlab.coderslab.pl/img/p/2/1/21-home_default.jpg']")).click();

        //Check if  product have promotion
        WebElement save20 = driver.findElement(By.xpath("//span[@class='discount discount-percentage']"));
        String save = save20.getText();
        if (save20.isDisplayed()) {
            System.out.println("This product have " + save);
        } else {
            System.out.println("This product doesn't have promotion");
        }

        //Size
        driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[3]")).click();

        //Wait for load page
        Thread.sleep(500);

        //Quantity
        WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        quantity.click();
        quantity.clear();
        quantity.sendKeys("5");

        //Add product to basket
        driver.findElement(By.xpath("//button[@class='btn btn-primary add-to-cart']")).click();
        Thread.sleep(1000);

        //Continue buying
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=order']")).click();

        //Address confirmation
        driver.findElement(By.name("confirm-addresses")).click();

        //Choose shipping method
        driver.findElement(By.name("confirmDeliveryOption")).click();

        //Choose payment method
        driver.findElement(By.id("payment-option-1")).click();

        //Agree checkbox and end of ordering
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary center-block']")).click();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
}

