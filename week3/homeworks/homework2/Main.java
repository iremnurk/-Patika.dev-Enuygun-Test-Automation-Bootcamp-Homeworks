import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
         ChromeDriver chromeDriver;
         
        Actions act1= new Actions();
        act1.url();  //url metodu ile siteye gidip
        act1.signUpClick();  //üyeola tıklama

        Actions act2=new Actions();
        act2.url();
        act2.loginClick();  //giriş yapa tıkla
    }
}
