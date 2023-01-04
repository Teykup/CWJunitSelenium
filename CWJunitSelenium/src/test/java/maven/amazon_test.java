package maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class amazon_test {
    WebDriver driver;

    @Before
    public void startup(){
        WebDriverManager .chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void AmazonTestCase() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.click();
        searchbox.sendKeys("gamepower keyboard rgb" + Keys.ENTER);
        Thread.sleep(10000);
        WebElement find = driver.findElement(By.xpath("//h1[1]/div[1]/div[1]/div[1]/div[1]/span[1]"));// //div[@data-uuid='3f24de92-ff72-4613-9084-ae4d1818996b']//child::span[1]
        String result = find.getText();
        System.out.println(result+" gamepower keyboard rgb");

    }
}
