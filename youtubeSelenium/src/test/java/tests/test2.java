package tests;

import org.openqa.selenium.By;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test2 {//form doldurma
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.cssSelector("div[class='category-cards'] div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
        element.click();
        WebElement Webtables = driver.findElement(By.id("item-3"));
        Webtables.click();
        WebElement Add = driver.findElement(By.id("addNewRecordButton"));
        Add.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        firstName.sendKeys(new CharSequence[]{"samet"});
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        lastName.sendKeys(new CharSequence[]{"öztürk"});
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        email.sendKeys(new CharSequence[]{"sametozturk1@gmail.com"});
        WebElement age = driver.findElement(By.id("age"));
        age.click();
        age.sendKeys(new CharSequence[]{"30"});
        WebElement Salary = driver.findElement(By.id("salary"));
        Salary.click();
        Salary.sendKeys(new CharSequence[]{"2000"});
        WebElement Department = driver.findElement(By.xpath("//div//input[@id=\"department\"]"));
        Department.click();
        Department.sendKeys(new CharSequence[]{"engineer"});
        WebElement Submit = driver.findElement(By.id("submit"));
        Submit.click();
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,450)", new Object[]{""});

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var14) {
            throw new RuntimeException(var14);
        }

        driver.quit();
    }
}