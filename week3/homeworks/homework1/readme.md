# ODEV 1
## Selenyum ile Chrome farklı profil ile nasıl açılır?



* Selenium ile Chrome varsayılan profilinizi veya kullandığınız herhangi bir profilinizi açabiliriz. 
* Chrome profil yolunu almak için Chrome tarayıcısına chrome://version/ yazmamız ve dosya yolunu öğrenmemiz gerekiyor.
* İstenilen Chrome profilini açmak için ChromeOptions sınıfını kullanmamız gerekiyor.
* Chrome profilinin yolunu belirtmek için add_argument yöntemini kullanmamız gerekiyor.


```
ChromeOptions options = new ChromeOptions();
 options.addArguments("--user-data-dir=C:/Users/username/AppData/Local/Google/Chrome/");
 options.addArguments("--profile-directory=Profile 3"); 
 WebDriver driver = new ChromeDriver(options);
```

## CHROME OPTIONS  Sınıfı nedir?
### Chromeoptions Sınıfı , Selenium WebDriver'da Chrome
### sürücüsünün çeşitli özelliklerini değiştirmek için kullanılan bir kavramdır.
### Chrome seçenekleri sınıfı, genellikle Chrome sürücü oturumlarını özelleştirmek için
### İstenen Yetenekler ile birlikte kullanılır. Chrome'u maksimum modda açma, mevcut uzantıları
### devre dışı bırakma, açılır pencereleri devre dışı bırakma vb. gibi çeşitli işlemleri
### gerçekleştirmenize yardımcı olur.
