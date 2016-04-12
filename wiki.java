import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by smeta on 11.04.2016.
 */
public class Wiki extends TestCase{
    private WebDriver driver = new FirefoxDriver();

    private By inputID = By.id("searchInput");
    private By inputClass = By.className("firstHeading");
   

    private String str ="My Little Pony: Friendship Is Magic\n";
    @BeforeClass
    public void setUp() throws Exception {
        this.driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }
    @Test
    public void testWiki() throws Exception{
        System.out.println(this.driver.getCurrentUrl());
        //  driver.findElement(By.id("lst-ib").sendKeys("hello");
        WebElement searchField=driver.findElement(inputID);
        searchField.sendKeys(str);
        //  searchField.submit();

        WebDriverWait wait = new WebDriverWait(driver,35);
        System.out.println(driver.getTitle());
        wait.until(ExpectedConditions.titleContains("Pony"));

        System.out.println(this.driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        String articleTitle=driver.findElement(inputClass).getText();

        assertTrue("Article Title does not contain Pony",articleTitle.contains("Pony"));

    }


    @AfterClass
    public void tearDown() throws Exception{
        this.driver.quit();
    }
}
