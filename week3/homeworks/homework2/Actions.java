import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class Actions extends BasePage {
    WebElement webElement,weblement2;
    public Actions() {
        setUp("CHROME");
    }//Kalıtım yolu ile BasePageden  Driverı ayağa kaldırma kısmı alınır ve google seçilir

    public void url() {
        driver.get("https://www.enuygun.com/"); //sitemiz

    }
    public void signUpClick(){
        webElement=driver.findElement(By.xpath("//*[text()='Üye Ol']"));//xpath ile üye olu text'i ile bulma
        webElement.click();                                             //ve tıklama


    }

    public void loginClick(){
        weblement2=driver.findElement(By.xpath("//*[@id='ctx-LoginBtn']")); //xath ile giriş yap butonunu id ile bulma
        weblement2.click();                                                 //ve tıklama
    }

}