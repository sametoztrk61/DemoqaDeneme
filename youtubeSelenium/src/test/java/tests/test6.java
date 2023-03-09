package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.cssSelector("div[class='category-cards'] div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
        element.click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)","");
        WebElement Upload = driver.findElement(By.cssSelector("#item-7 > span"));
        Upload.click();
        WebElement upload = driver.findElement(By.id("uploadFile"));
        upload.sendKeys("C:/Users/Samet/Desktop/Ekran görüntüsü 2023-02-27 193718.png");
        Thread.sleep(1000);
        driver.quit();

    }
}
