package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test15 {
    WebDriver driver;
    @BeforeTest
    public void AnaurlGiris (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.card-up")).click();
    }
    @Test
    public void Acordion() throws InterruptedException {
        //JavascriptExecutor jsx  =(JavascriptExecutor) driver;
        //jsx.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[1]/span")).click();
        WebElement acik = driver.findElement(By.xpath("//div[@class='card'][1]/div[2]"));
        String yazi = acik.getAttribute("class");
        System.out.println(yazi);
        driver.findElement(By.xpath("//div[@class='card'][1]/div[1]")).click();

        String kapanıyor = acik.getAttribute("class");
        System.out.println(kapanıyor);

        Thread.sleep(1000);
        String kapali = acik.getAttribute("class");
        System.out.println(kapali);


    }
    @AfterTest
    public void SonTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
