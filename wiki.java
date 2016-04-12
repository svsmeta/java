import junit.framework.TestCase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by smeta on 11.04.2016.
 */
public class Wiki extends TestCase{
    private static WebDriver driver = new FirefoxDriver();// static надо, чтобы был один инстанс создан
    private By inputID = By.id("searchInput");
    private By inputClass = By.className("firstHeading");
    private String str ="My Little Pony: Friendship Is Magic"+ Keys.ENTER;
    private String str1 ="New York\n";
    private String baseUrl="https://en.wikipedia.org/wiki/Main_Page";


    @BeforeClass
    public  void setUp() throws Exception {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testWiki() throws Exception{
        System.out.println(driver.getCurrentUrl());
        WebElement searchField=driver.findElement(inputID);
        searchField.sendKeys(str);
        WebDriverWait wait = new WebDriverWait(driver,35);
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.titleContains("Pony"));

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        String articleTitle=driver.findElement(inputClass).getText();

        assertTrue("Article Title does not contain Pony",articleTitle.contains("Pony"));

    }
    @Test
    public void testWikiPage() throws Exception{
        System.out.println(driver.getCurrentUrl());
        System.out.println("test2");

        WebElement searchField=driver.findElement(inputID);
        searchField.sendKeys(str1);


        WebDriverWait wait = new WebDriverWait(driver,35);
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.titleContains("New"));

        System.out.println(this.driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        String articleTitle=driver.findElement(inputClass).getText();

        assertTrue("Article Title does not contain New York",articleTitle.contains("York"));

    }

    @AfterClass
    public void tearDown() throws Exception{
        driver.quit();
    }
}
