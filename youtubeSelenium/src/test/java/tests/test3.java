package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test3 {//tek tık çift tık sağ tık
   public static void main(String[] args) throws InterruptedException {
     WebDriverManager.chromedriver().setup();
  WebDriver driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://demoqa.com/");
  WebElement element = driver.findElement(By.cssSelector("div[class='category-cards'] div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
  element.click();
  WebElement Webtables = driver.findElement(By.id("item-4"));
  Webtables.click();
  WebElement DoubleClick =driver.findElement(By.id("doubleClickBtn"));
  Actions action =new Actions(driver);       // WebDriver parametresi
  action.doubleClick(DoubleClick).perform(); // double tıklama

  WebElement message = driver.findElement(By.id("doubleClickMessage"));
  String messageText = message.getText();
  System.out.println(messageText);

  WebElement RightClick =driver.findElement(By.cssSelector("#rightClickBtn"));
     //Actions actio =new Actions(driver);
  RightClick.click();
  WebElement ClickMe = driver.findElement(By.xpath("//div/button[starts-with(text(),'Click Me')]"));
  ClickMe.click();//starts-with başlayandemek contains içinde bulunan demek

  action.contextClick(RightClick).perform();






  Thread.sleep(5000);
  driver.quit();

 }
}
