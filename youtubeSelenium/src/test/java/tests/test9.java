package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test9 {
    static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(3) > div > div.card-up")).click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)","");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[3]/span")).click();

        driver.switchTo().frame("frame1");
        WebElement text =driver.findElement(By.id("sampleHeading"));
        String text1 =text.getText();
        System.out.println(text1);

      driver.switchTo().parentFrame();
      WebElement paragraf =driver.findElements(By.cssSelector("div[id='framesWrapper'] div")).get(0);
      String paragraf1 =paragraf.getText();
        System.out.println(paragraf1);
        // 2 kısımda aynı altta elementleri liste olarak alıyoruz. sonradan seçiyoruz.
        //üstte seçip alıyoruz
      // List<WebElement> elementList =driver.findElements(By.cssSelector("div[id='framesWrapper'] div"));
      // String paragraph = elementList.get(0).getText();
      // System.out.println(paragraph);
        driver.switchTo().frame(2);
        WebElement text2 =driver.findElement(By.id("sampleHeading"));
        String text3 =text2.getText();
        System.out.println(text3);





      driver.quit();
    }
}
