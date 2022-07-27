import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChrome {
    public WebDriver driver;
    public DriverChrome(){
        this.driver = new ChromeDriver();
    }
}
