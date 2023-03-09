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

public class test14 {
    WebDriver driver;
    @BeforeTest
    public void test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(3) > div > div.card-up")).click();
    }
    @Test
    public void AnaTest() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)","");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[5]")).click();
    }
    @Test
    public void SmallModal(){
        driver.findElement(By.cssSelector("#showSmallModal")).click();
        WebElement text =driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-body"));
        String Text = text.getText();
        System.out.println(Text);
        driver.findElement(By.id("closeSmallModal")).click();
    }
    @Test
    public void LargeModal(){
        driver.findElement(By.id("showLargeModal")).click();
        WebElement text1 = driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-body > p"));
        System.out.println(text1.getText());
        driver.findElement(By.id("closeLargeModal")).click();
    }
    @AfterTest
    public void SonTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
