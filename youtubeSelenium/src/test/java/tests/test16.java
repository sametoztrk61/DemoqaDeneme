package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class test16 {
    WebDriver driver;
    @BeforeTest
    public void AnaurlGiris (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.card-up")).click();
    }
    @Test
    public void AutoComplate1 () throws InterruptedException {
        Thread.sleep(2000);
        driver.findElements(By.xpath("//*[@id=\"item-1\"]")).get(2).click();
        Thread.sleep(1000);
        WebElement input = driver.findElement(By.id("autoCompleteSingleInput"));

        input.sendKeys("R");
        Thread.sleep(1000);

        List<WebElement> Suggestions = driver.findElements(By.cssSelector("div.auto-complete__option"));

        for (WebElement suggestion : Suggestions){
            String text = suggestion.getText();
            System.out.println(text);
            if(text.toLowerCase().contains("r")){
                System.out.println(text + " has r letter");
            }
        }
        Suggestions.get(0).click();
    }
    @Test //bu test kendi basına edgil yukarıdaki testin for dögüsünün içine de yazılabilir.
    public void yazdigimizaTikla(){
        List<WebElement> Suggestions = driver.findElements(By.cssSelector("div.auto-complete__option"));


        for (WebElement suggestion : Suggestions) {
            String text = suggestion.getText();
            System.out.println(text);
            if (text.equalsIgnoreCase("red")) {
                suggestion.click();
                break;
            }
        }

    }
    @AfterTest
    public void SonTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
