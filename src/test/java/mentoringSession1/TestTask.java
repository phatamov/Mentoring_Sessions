package mentoringSession1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestTask {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Test (priority = 2)
    public void seleniumTest1() {
        driver.get("https://www.bloomberg.com/markets/stocks");
        List<String> expected = Arrays.asList("NAME", "VALUE", "NET", "CHANGE", " % CHANGE", "1 MONTH", "1 YEAR", "TIME (EDT)");
        List<String> actual = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-view-uid='1|0_3_3']//tr[@class='data-table-headers']"));
        for (WebElement element : elements){
            actual.add(element.getText());
            assertEquals(actual, expected);
        }
    }

    @Test (priority = 1)
    public void seleniumTest2() {
        driver.get("https://www.dice.com/");
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("google-location-search")).clear();
        driver.findElement(By.id("google-location-search")).sendKeys("Washington, DC, USA", Keys.TAB, Keys.ENTER);
        driver.findElement(By.id("043881b1fcbf56dc12203ba27b887a56")).click();
    }

    @Test(priority = 3, dependsOnMethods = {"seleniumTest1", "seleniumTest2"})
    public void testDependencies() {
        System.out.println("Dependencies Test");
    }

    @Test(enabled = false)
    public void testEnabled() {
        System.out.println("Enabled Test");
    }

    @Ignore
    public void testIgnore() {
        System.out.println("Ignoring Test");
    }

        @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
