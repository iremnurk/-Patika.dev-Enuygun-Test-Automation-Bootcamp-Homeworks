import org.openqa.selenium.WebDriver;

public class DriverSetup {
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    public DriverSetup(){

        this.firefoxDriver = new DriverFirefox().driver;
        this.chromeDriver =  new DriverChrome().driver;
    }
}
