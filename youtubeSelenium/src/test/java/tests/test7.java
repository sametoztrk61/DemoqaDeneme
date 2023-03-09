package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class test7 {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement AlertsFrame =driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(3) > div > div.card-up"));
        AlertsFrame.click();
        WebElement Browser = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[1]/span"));
        Browser.click();
        WebElement NewTab = driver.findElement(By.id("windowButton"));//taba işlem yapmakla aynı
        NewTab.click();
        List<String> tabs=new ArrayList<>(driver.getWindowHandles());//tabs listesi oluşruyor getWindow komutu ile açık olan tabları görebiliriz.
        System.out.println(tabs.size());// tabs sayısını gösterir.
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(0)); //istediğimiz taba geçeriz.
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl()); //o an bulundugumuz url
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
        driver.close();


    }
}
