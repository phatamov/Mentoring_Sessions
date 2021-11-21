package mentoringSession2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Iframes {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://the-internet.herokuapp.com/iframe");


        driver.switchTo().frame("mce_0_ifr"); // switches the context to the iframe

        System.out.println(driver.findElement(By.xpath("//p")).getText());

//        driver.switchTo().defaultContent();
//        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).click();



    }
}
