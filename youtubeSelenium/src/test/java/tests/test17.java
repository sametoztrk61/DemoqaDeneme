package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class test17 {

    WebDriver driver;



    @BeforeTest
    public void BaseUrl(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.card-up")).click();

    }
    @Test(priority = 1)
    public void DatePicker(){
        driver.findElements(By.id("item-2")).get(2).click();
        WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
        date.click();
        WebElement Month = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(Month);//select seleniumın içinde var incele kısmında select içerisinden seçim yaparken kullanılır.
        select.selectByValue("5");
        WebElement Year = driver.findElement(By.className("react-datepicker__year-select"));
        Select select1 =new Select(Year);
        select1.selectByIndex(5);
        List<WebElement> Gunler = driver.findElements(By.cssSelector("div.react-datepicker__day"));
        for (WebElement dayElement : Gunler){
            System.out.println(dayElement.getText());
            String text = dayElement.getText();
            if (text.equals("19")){
                dayElement.click();
                break;

            }

        }
    }
    @Test(priority = 2)
    private void SelectDate(String year ,String month ,String day){


        driver.findElements(By.id("item-2")).get(2).click();
        WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
        date.click();
        WebElement Month = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(Month);//select seleniumın içinde var incele kısmında select içerisinden seçim yaparken kullanılır.
        select.selectByVisibleText(month);
        WebElement Year = driver.findElement(By.className("react-datepicker__year-select"));
        Select select1 =new Select(Year);
        select1.selectByVisibleText(year);
        List<WebElement> Gunler = driver.findElements(By.cssSelector("div.react-datepicker__day"));
        for (WebElement dayElement : Gunler){
            System.out.println(dayElement.getText());
            String text = dayElement.getText();
            if (text.equals(day)){
                dayElement.click();
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
