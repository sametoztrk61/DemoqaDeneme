package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.internal.common.assertion.Assertion;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test19 {
    WebDriver driver;

    @BeforeTest
    public void BaseUrl(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.card-up")).click();

    }
    @Test
    public void kaydirmaTesti() throws InterruptedException {
        JavascriptExecutor jsx  =(JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,300)","");
        driver.findElements(By.id("item-3")).get(2).click();
        //WebElement Enable = driver.findElement(By.xpath("//*[@id=\"item-3\"]"));
        //WebDriverWait wait =new WebDriverWait(driver,6);
        //wait.until(ExpectedConditions.elementToBeClickable(Enable));
        //Enable.click();
        WebElement slider = driver.findElement(By.cssSelector("input[class='range-slider range-slider--primary']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider,50,0).perform();
        WebElement Rakam =driver.findElement(By.cssSelector("div[class='range-slider__tooltip__label']"));
        String rakam1 =Rakam.getText();
        System.out.println(rakam1);
        WebElement SliderValue = driver.findElement(By.cssSelector("input[id='sliderValue']"));
        String rakam2 =SliderValue.getAttribute("value");
        System.out.println(rakam2);
        Assert.assertEquals(rakam1,rakam2,"basardın");//rakamlardan bırını değiştirep gör
        if (rakam1.equals(rakam2)){
            System.out.println("test basarılı!");
        }


    }
    @AfterTest
    public void SonTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
