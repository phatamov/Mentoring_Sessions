package mentoringSession2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FluentWaitExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

// Click on timer so clock will start
        driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

// Create object of FluentWait class and pass webdriver as input
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
// Max time for wait- If conditions are not met within this time frame then it will fail the script
        wait.withTimeout(20, TimeUnit.SECONDS);
// It should poll WebElement after every single second
        wait.pollingEvery(1, TimeUnit.SECONDS);

// We are creating Function here which accept WebDriver and output as WebElement-
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {

            // apply method- which accept WebDriver as input
            @Override
            public WebElement apply(WebDriver driver) {

                // find the element
                WebElement e = driver.findElement(By.xpath("//p[@id='demo']"));

// Will capture the inner Text and will compare with WebDriver
// If condition is true then it will return the element and wait will be over
                if (e.getAttribute("innerHTML").equalsIgnoreCase("WebDriver")) {
                    System.out.println("Value is >>> " + e.getAttribute("innerHTML"));
                    return e;
                }

// If condition is not true then it will return null and it will keep checking until condition is not true
                else
                    System.out.println("Value is >>> " + e.getAttribute("innerHTML"));
                return null;

            }
        });

// If element is found then it will display the status
        System.out.println("Final visible status is >>>>> " + element.isDisplayed());
    }


}