package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class test4 {//tıklamadan bekleme renk değişince bekleme görününce bekleme
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.cssSelector("div[class='category-cards'] div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
        element.click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)","");
        WebElement Dynamic = driver.findElement(By.cssSelector("#item-8 > span"));
        Dynamic.click();

        //Thread.sleep(6000);

      // WebElement Enable = driver.findElement(By.id("enableAfter"));
      // WebDriverWait wait =new WebDriverWait(driver,6); //Thread.sleep(6000)bunun yerine
      // wait.until(ExpectedConditions.elementToBeClickable(Enable));   //Thread.sleep(6000)bunun yerine
      // boolean tikla = Enable.isEnabled();
      // System.out.println(tikla);
      // Enable.click();

      // WebElement ColorChange = driver.findElement(By.id("colorChange"));
      // String className = ColorChange.getAttribute("class"); //elementteki class kısmını aldık
      // System.out.println("bofore change;"+className);
      // WebDriverWait wait =new WebDriverWait(driver,6); //webdriverda beklemeyi tanımladık bir kere tanıladıktan sonra tekrarlamaya gerek yok
      // wait.until(ExpectedConditions.attributeToBe(ColorChange,"class","mt-4 text-danger btn btn-primary")); //class value degeri gerçekleşene kadar bekledik
      // className = ColorChange.getAttribute("class");
      // System.out.println("after change;"+className);
      // boolean ColorTikla = ColorChange.isEnabled();
      // System.out.println(ColorTikla);
      // ColorChange.click();
      // Thread.sleep(1000);

        WebDriverWait wait =new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        WebElement Visible = driver.findElement(By.id("visibleAfter"));
        boolean visibleTikla = Visible.isEnabled();
        System.out.println(visibleTikla);
        Visible.click();
        Thread.sleep(1000);
        driver.quit();
    }
}
