package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class test21 {
    //siteleri durdurmak için
   /* document.addEventListener('keydown', function (e) {
        if (e.keyCode == 119) { // F8
            debugger;
        }
    }, {
        capture: true
    });*/
    //kullanıp istediğimiz öge görununce f8 e basabiliriz yada elementin uzerine gelip break on tusundan attebutede bır degısım oluncada durdurabılırız.

@Test
public static void main(String[] args) {
    WebDriver driver;
WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/tool-tips");
    WebElement toolTips = driver.findElement(By.id("toolTipButton"));
    Actions action = new Actions(driver);
    action.moveToElement(toolTips).perform();
    WebDriverWait wait = new WebDriverWait(driver,4);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")));
    WebElement tool = driver.findElement(By.className("tooltip-inner"));
    System.out.println("text ; " + tool.getText());

}}
