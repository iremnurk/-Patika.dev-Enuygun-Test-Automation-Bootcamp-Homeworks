import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Odev1 {
    public static void main(String[] args) {
        //FARKLI GOOGLE PROFİLİ İLE CHROME AÇMA -ÖDEV
        Path resourceDirectory = Paths.get("src","main","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();

        System.out.println(absolutePath);
        System.setProperty("webdriver.chrome.driver", absolutePath+"/binary/chromedriver");
        //Chrome Tarayıcı kullandığınızdan,set property yöntemini kullanarak
        // chromedriver.exe dosyasının yolunu ayarladım.


        ChromeOptions options = new ChromeOptions();  //Chromeda farklı profille açmak adına options nesnesi olıuşturdum.

        //Chrome'a hangi profili kullanacağını söylemek için
        // user-data-dir Chrome komut satırı anahtarını kullanabilirsiniz:
        options.addArguments("--user-data-dir=C:/Users/iremn/AppData/Local/Google/Chrome/");
        options.addArguments("--profile-directory=Profile 3");  //Kullanılacak Chrome  Profilim eklendi



        options.addArguments("--start-maximized");  //büyük pencere açılımı
        WebDriver driver = new ChromeDriver(options);


        String url = "https://demoqa.com/webtables";
        driver.get(url);




    }


}


   /*CHROME OPTIONS  Sınıfı nedir?
    Chromeoptions Sınıfı , Selenium WebDriver'da Chrome
    sürücüsünün çeşitli özelliklerini değiştirmek için kullanılan bir kavramdır.
    Chrome seçenekleri sınıfı, genellikle Chrome sürücü oturumlarını özelleştirmek için
    İstenen Yetenekler ile birlikte kullanılır. Chrome'u maksimum modda açma, mevcut uzantıları
    devre dışı bırakma, açılır pencereleri devre dışı bırakma vb. gibi çeşitli işlemleri
     gerçekleştirmenize yardımcı olur.
    */
