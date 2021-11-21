package mentoringSession2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

        driver.get("https://www.tutorialspoint.com/index.htm");
        driver.findElement(By.xpath("//a[@href='https://www.tutorialspoint.com/courses']")).click();
        System.out.println(driver.findElement(By.partialLinkText("Parviz Hatamov")).getText());


    }
}
