import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class FirstTest {

    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) throws MalformedURLException {
        String Node = "http://localhost:4444/wd/hub";
        if(browser.equals("firefox")) {
            driver = new RemoteWebDriver(new URL(Node), DesiredCapabilities.firefox());
        } else if(browser.equals("chrome")) {
            driver = new RemoteWebDriver(new URL(Node), DesiredCapabilities.chrome());
        }
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("Hello! ");
        driver.get("");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("");
        driver.findElement(By.cssSelector(".dp-login__actions .base-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Open cart')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".dp-cart-checkout-list__list-actions .dp-product-upload-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("upload-file")).sendKeys("/selenium/upload_products.csv");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Upload cart')]")).click();
        Thread.sleep(20000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
