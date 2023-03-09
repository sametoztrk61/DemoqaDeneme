package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test8 {
    static WebDriver driver;
    @BeforeTest
    public static void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(3) > div > div.card-up")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]/span")).click();
        //Alert alert = driver.switchTo().alert(); boyle diyerek kodda "driver.switchTo().alert()" yerine alert diyebilirim.

        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait=new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        Thread.sleep(1000);

        driver.findElement(By.id("confirmButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        driver.findElement(By.id("promtButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("selamlar");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();



        Thread.sleep(1000);
        driver.quit();
    }


}


