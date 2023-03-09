package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class test18 {
    WebDriver driver;
@Test
    public  void test () {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demoqa.com/");
    driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(4) > div > div.card-up")).click();
    driver.findElements(By.id("item-2")).get(2).click();
    SelectDate("2015","April","5");}
private void SelectDate(String year ,String month ,String day){
        WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
        date.click();
        WebElement Month = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(Month);//select seleniumın içinde var incele kısmında select içerisinden seçim yaparken kullanılır.
        select.selectByVisibleText(month);
        WebElement Year = driver.findElement(By.className("react-datepicker__year-select"));
        Select select1 = new Select(Year);
        select1.selectByVisibleText(year);
        List<WebElement> Gunler = driver.findElements(By.cssSelector("div.react-datepicker__day"));
        for (WebElement dayElement : Gunler) {
            System.out.println(dayElement.getText());
            String text = dayElement.getText();
            if (text.equals(day)) {
                dayElement.click();
                break;
            }
        }
    }
}

