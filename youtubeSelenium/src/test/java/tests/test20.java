package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class test20 {
    WebDriver driver;

    @BeforeTest
    public void BaseUrl(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.card-up")).click();

    }
    @Test(priority = 1)
    public void kaydirmaTesti() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,300)", "");
        driver.findElements(By.id("item-4")).get(2).click();
        driver.findElement(By.id("startStopButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("startStopButton")).click();
        WebElement ProgressBar = driver.findElement(By.cssSelector("#progressBar > div"));
        String Progress = ProgressBar.getAttribute("aria-valuenow");
        System.out.println(Progress);
    }
    @Test(priority = 2)
    public void Dolunca() {
       JavascriptExecutor jsx = (JavascriptExecutor) driver;
       jsx.executeScript("window.scrollBy(0,300)", "");
        driver.findElements(By.id("item-4")).get(2).click();
        driver.findElement(By.id("startStopButton")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.id("startStopButton")).click();
        WebElement ProgressBar = driver.findElement(By.cssSelector("#progressBar > div"));
        WebDriverWait wait =new WebDriverWait(driver,9);
        wait.pollingEvery(Duration.ofMillis(10));//her 10 mili saniyede kontrol et.Normalde 0.5 sn kontrol edıyor default olarak.
        wait.until(ExpectedConditions.attributeToBe(ProgressBar,"aria-valuenow","50")); //bu attribute degeri 50 olana kadar
        driver.findElement(By.id("startStopButton")).click();


    }
    @Test
    public void Dolunca1() throws InterruptedException {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,300)", "");
        driver.findElements(By.id("item-4")).get(2).click();
        driver.findElement(By.id("startStopButton")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.id("startStopButton")).click();
        WebElement ProgressBar = driver.findElement(By.cssSelector("#progressBar > div"));
        WebDriverWait wait =new WebDriverWait(driver,10);
        wait.pollingEvery(Duration.ofMillis(10));//her 10 mili saniyede kontrol et.Normalde 0.5 sn kontrol edıyor default olarak.
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("button[class='mt-3 btn btn-primary']"),"id","resetButton")); //bu attribute degeri 50 olana kadar
        //driver.findElement(By.id("startStopButton")).click();
    }

    @AfterTest
    public void SonTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
