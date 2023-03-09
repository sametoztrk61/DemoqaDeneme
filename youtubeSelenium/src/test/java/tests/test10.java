package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test10 {
    static WebDriver driver;
    @Test

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(3) > div > div.card-up")).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)","");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[4]")).click();


        driver.switchTo().frame("frame1");
        WebElement Parent = driver.findElement(By.tagName("body"));
        String PFrame = Parent.getText();
        System.out.println(PFrame);
        driver.switchTo().frame(0);
        WebElement Child = driver.findElement(By.tagName("body"));
        System.out.println(Child.getText());

        driver.quit();



    }
}
