package maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class g_hw {
    /*
        1. https://www.amazon.com/ adresine gidin.
        2.  Assertion kullanarak Amazon web sitesine gittiğinizi doğrulayın.
        3. Kategori DropDown'dan Books kategorisini seçin ve arama kutusuna "Selenium" yazdırıp aratın.
        4. Çıkan kitaplardan 2. ve 5. kitabın isminde "Selenium" kelimesinin geçtiğini doğrulayın.
        5. Ç"ıkan sonuç sayısının 500'den büyük olduğunu doğrulayın."

     */
    static int b;
    WebDriver driver;

    @Before
    public void Start_up() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void Shutdown() {
        driver.quit();
    }

    @Test
    public void Amazon_page() {
        //1. https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.1 Change country kapatma
        WebElement chng_cntry = driver.findElement(By.xpath("//input[@data-action-type='DISMISS']"));
        chng_cntry.click();

        //2.  Assertion kullanarak Amazon web sitesine gittiğinizi doğrulayın.
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com/"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Kategori DropDown'dan Books kategorisini seçin ve arama kutusuna "Selenium" yazdırıp aratın.
        WebElement drop_down = driver.findElement(By.id("nav-search-dropdown-card"));
        drop_down.click();
        Select hamburger = new Select(driver.findElement(By.xpath("//select[@name='url']")));
        hamburger.selectByVisibleText("Books");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Selenium" + Keys.ENTER);

        //4. Çıkan kitaplardan 2. ve 5. kitabın isminde "Selenium" kelimesinin geçtiğini doğrulayın.
        WebElement second = driver.findElement(By.xpath("//div[@data-cel-widget='MAIN-SEARCH_RESULTS-2']//span[@class='a-size-medium a-color-base a-text-normal']"));
        Assert.assertTrue(second.getText().toLowerCase().contains("selenium"));
        WebElement fifth = driver.findElement(By.xpath("//div[@data-cel-widget='MAIN-SEARCH_RESULTS-6']//span[@class='a-size-medium a-color-base a-text-normal']"));
        Assert.assertTrue(second.getText().toLowerCase().contains("selenium"));

        //5. Ç"ıkan sonuç sayısının 500'den büyük olduğunu doğrulayın."
        WebElement find = driver.findElement(By.xpath("//h1[1]/div[1]/div[1]/div[1]/div[1]/span[1]"));
        find.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        higher(find.getText(), b);
        Assert.assertTrue(b > 500);
    }

    public static void higher(String find, int b) {
        g_hw s = new g_hw();
        String a = find;
        s.b = Integer.parseInt(a.replaceAll("\\D", "").substring(3));
    }

}
