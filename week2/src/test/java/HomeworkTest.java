import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }


    @Test
    public void typeToSearch_true() {
        System.out.println("@Test");
        Path resourceDirectory = Paths.get("src", "main", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.out.println(absolutePath);
        System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver");//chromedriverimizin yolunu belirttik
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/webtables";
        driver.get(url);
        boolean expResult = true;       //beklediğimiz sonuç true

        WebElement searchingArea = driver.findElement(By.xpath("//input[@id='searchBox']"));//tag'i test olan id'si searchBox olan *typte to search alanı için xpathimizi yazdık.
        searchingArea.click();    //aramaKısmına tıklıyoruz
        //.isEnabled() metodu ile Web Element erisilebilir ise true yoksa false döner bizde
        //ödevimizde typte to search alanının varlığını test ediyoruz..
        boolean result = searchingArea.isEnabled();
        //System.out.println(searchingArea.isEnabled());//true ve ya false yazısını almak için println için yazdım.
        Assertions.assertEquals(expResult, result);  //assertEquals metodu iki değerin eşit olup olmadığını test etmek için kullanılır.
    }

    @Test
    public void typeToSearch_false() {
        System.out.println("@Test");
        Path resourceDirectory = Paths.get("src", "main", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.out.println(absolutePath);
        System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver");//chromedriverimizin yolunu belirttik
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/webtables";
        driver.get(url);
        boolean expResult = false;   //beklediğimiz sonuç false ,arama alanını olmama durumu için

        WebElement searchingArea = driver.findElement(By.xpath("//input[@id='searchBox']"));//tag'i test olan id'si searchBox olan *typte to search alanı için xpathimizi yazdık.
        //searchingArea.click();
        //.isEnabled() metodu ile Web Element erisilebilir ise true yoksa false döner bizde
        //ödevimizde typte to search alanının varlığını test ediyoruz..
        boolean result = searchingArea.isEnabled();
        //System.out.println(searchingArea.isEnabled());//true ve ya false yazısını almak için println için yazdım.
        Assertions.assertEquals(expResult, result);
    }
    @AfterEach
    public void afterEach() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("@AfterAll");
    }


}