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

public class test11 {
    static WebDriver driver;
    @BeforeTest

    public static void Test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void Test2(){
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

    }
    @Test
    public void Test3() throws InterruptedException {
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(3) > div > div.card-up")).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)","");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[3]/span")).click();
        Thread.sleep(1000);

        driver.switchTo().frame("frame1");
        WebElement text =driver.findElement(By.id("sampleHeading"));
        String text1 =text.getText();
        System.out.println(text1);

        driver.switchTo().parentFrame();
        WebElement paragraf =driver.findElements(By.cssSelector("div[id='framesWrapper'] div")).get(0);
        String paragraf1 =paragraf.getText();
        System.out.println(paragraf1);

        driver.switchTo().frame(2);
        WebElement text2 =driver.findElement(By.id("sampleHeading"));
        String text3 =text2.getText();
        System.out.println(text3);

    }
    @AfterTest
    public void Test4(){
        driver.quit();
    }
}
