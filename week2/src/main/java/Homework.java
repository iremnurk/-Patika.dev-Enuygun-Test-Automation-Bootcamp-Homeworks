import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Homework {
    public static void main(String[] args) throws InterruptedException {
        Path resourceDirectory = Paths.get("src","main","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.out.println(absolutePath);
        System.setProperty("webdriver.chrome.driver", absolutePath+"/binary/chromedriver");//chromedriverimizin yolunu belirttik

        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/webtables";
        driver.get(url);

        WebElement searchingArea=driver.findElement(By.xpath("//input[@id='searchBox']"));//tag'i test olan id'si searchBox olan *typte to search alanı için xpathimizi yazdık.
        searchingArea.click(); //arama yerine  tıklama
        //.isEnabled() metodu ile Web Element erisilebilir ise true yoksa false döner bizde
        //ödevimizde typte to search alanının varlığını test ediyoruz..
        System.out.println(searchingArea.isEnabled());//true ve ya false yazısını almak için println için yazdım.
        //Thread.sleep(2000);
        //searchingArea.sendKeys("Alden");

        //NOT:
        //JUNİT İLE BİRİM TESTİ test klasörü altındaki  HomeworkTest.java 'dadır.
        

    }


}
