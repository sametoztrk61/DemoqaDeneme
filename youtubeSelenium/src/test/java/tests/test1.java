package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Closeable;

public class test1 {//kutuya tıklama
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement elements = driver.findElements(By.cssSelector("div[class='category-cards'] div  div div")).get(0);
        elements.click();
        WebElement checkbox = driver.findElement(By.id("item-1"));
        checkbox.click();
       // WebElement hometikla = driver.findElement(By.cssSelector("label[for=tree-node-home] span svg"));
       // hometikla.click();
        WebElement HomeListele = driver.findElement(By.cssSelector("button[class=\"rct-collapse rct-collapse-btn\"]"));
        HomeListele.click();
        WebElement DesktopListele = driver.findElements(By.cssSelector("li[class=\"rct-node rct-node-parent rct-node-collapsed\"] span button svg")).get(0);
        DesktopListele.click();
        WebElement DocumentsListele = driver.findElements(By.cssSelector("li[class=\"rct-node rct-node-parent rct-node-collapsed\"] span button svg")).get(0);
        DocumentsListele.click();
        WebElement DownloadsListele = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > button > svg"));
        DownloadsListele.click();
        WebElement Excel = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > ol > li:nth-child(2) > span > label > span.rct-checkbox > svg"));
        boolean exceleTik = Excel.isEnabled(); //Bu elemente tıklanabılır mı bunu söylüyor cevap true or false
        System.out.println(exceleTik);
        Excel.click();
        Excel = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > ol > li:nth-child(2) > span > label > span.rct-checkbox > svg"));
        String excelTiklanmis = Excel.getAttribute("class"); //getAttribute ile aradığımız elementin class aldık
        if(excelTiklanmis.equals("rct-icon rct-icon-check")) {
            System.out.println("Excele Tıklanmış");
        }else{
            System.out.println("Excele tıklanmamış!");
        }

        Thread.sleep(2000L);
        driver.quit();
        /*try {

        }catch (.......){} böyle bir yapı var bu yapının amacı try kısmına yazdığımız bir yapı eğer gerçekleşemezse
        catch içine yazdığımız kısım çalışır.nokta nokta olan kısma try kısmına yazdığımız kodu gercekleşmemesi ile
        oluşan hata yazısı yazılır(ElementClickInterception)
        */


    }
}
