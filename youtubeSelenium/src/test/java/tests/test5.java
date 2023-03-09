package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

public class test5 {//kırık link testi
    public static void main(String[]args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.cssSelector("div[class='category-cards'] div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
        element.click();
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)","");
        WebElement Dynamic = driver.findElement(By.cssSelector("#item-6 > span"));
        Dynamic.click();
       CloseableHttpClient client = HttpClientBuilder.create().build();
       HttpGet request =new HttpGet("http://demoqa.com");
       HttpResponse response = client.execute(request);
       int statusCode =response.getStatusLine().getStatusCode();
       System.out.println(statusCode);
      // CloseableHttpClient client = HttpClientBuilder.create().build();
      //  HttpGet request =new HttpGet("http://the-internet.herokuapp.com/status_codes/500");
      //  HttpResponse response = client.execute(request);
      //  int statusCode =response.getStatusLine().getStatusCode();
      //  System.out.println(statusCode);


    }
}
