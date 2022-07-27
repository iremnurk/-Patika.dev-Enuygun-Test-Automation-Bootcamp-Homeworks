import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class BasePage {
    public WebDriver driver;

    protected WebDriver setUp(String browserName) {  //Driverımızı kontrol ediyoruz firefox mu google mı ona göre
                                                     //driveı oluşturuyoruz
        if (driver == null) {
            if (browserName == "CHROME") {
                System.setProperty("webdriver.chrome.driver", DriverPath.DRIVERPATH_CHROME);
                driver = new ChromeDriver();

            } else if (browserName == "FF") {

               // System.setProperty("webdriver.gecko.driver", DriverPath.DRIVERPATH_FIREFOX);
                //driver = new FirefoxDriver();


            }
        }
        return driver;
    }


}
