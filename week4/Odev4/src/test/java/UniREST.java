import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UniREST {
    Random r=new Random(); //random sınıfı yardımıyla int değerinde id üretiyoruz
    int id=r.nextInt(10)+1;  //1 den 10 a kadar

    @Test
    public void succesfulTestPost() throws UnirestException {

        System.out.println(id);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://petstore.swagger.io/v2/store/order")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\r\n  \"id\": "+id+"," +
                        "\r\n  \"petId\": 5," +
                        "\r\n  \"quantity\": 0," +
                        "\r\n  \"shipDate\": \"2022-07-27T13:59:31.413Z\"," +
                        "\r\n  \"status\": " +
                        "\"placed\",\r\n  " +
                        "\"complete\": true\r\n}")
                .asString();
        Assert.assertEquals(200,response.getStatus());  //200 değerini bekliyorum,benim değerim
        /*
        Expected :200
        Actual   :200
         */

    }
    @Test
    public void unSuccesfultestPost() throws UnirestException {
        boolean deger=false;
        String shipDate="2022-07-27T13:59:31.413Z";
        String falseId="z1";  //id degeri sayı harici olamaz yanlış test koşumu için gerçekleştirilen string değer
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://petstore.swagger.io/v2/store/order")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\r\n  \"id\": "+falseId+"," +
                        "\r\n  \"petId\": 5," +
                        "\r\n  \"quantity\": 0," +
                        "\r\n  \"shipDate\": \""+shipDate+"\"," +
                        "\r\n  \"status\": " +
                        "\"placed\",\r\n " +
                        " \"complete\": "+deger+"\r\n}")
                .asString();
        Assert.assertEquals(200,response.getStatus());  //200 değerini bekliyorum,benim değerim yanlış olduğundan 400 dönecek
        /*
        Expected :400
        Actual   :200
         */

    }
    @Test    //Id >= 1 ve <= 10 değerine sahip tamsayı kimliklerini deneyin. Diğer değerler hataları oluşturacaktır.
    public void succesfulTestGet() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        String url="https://petstore.swagger.io/v2/store/order/"+id+"";
        HttpResponse<String> response = Unirest.get(url)
                .header("accept", "application/json")
                .asString();
        Assert.assertEquals(200,response.getStatus());
    }

    @Test  //Id değeri negatif veya 10 dan büyük bir değer seçip status kod 404 dönecek mi diye kontrol
    public void unSuccesfulTestGet() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        int yanlisId=12;
        String url="https://petstore.swagger.io/v2/store/order/"+yanlisId+"";
        HttpResponse<String> response = Unirest.get(url)
                .header("accept", "application/json")
                .asString();
        Assert.assertEquals(404,response.getStatus());  //
    }




    /*Delete kısmında başarılı sonuç için random post metodunda kullandığımız idyi kullanıp veriyi siliyoruz ve
    200 status code 'u alıyoruz çünkü id değerimiz pozitif ve integer
    */
    @Test
    public void succesfulDelete() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        String url="https://petstore.swagger.io/v2/store/order/"+id+"";
        HttpResponse<String> response = Unirest.delete(url)
                .header("accept", "application/json")
                .body("")
                .asString();
        Assert.assertEquals(200,response.getStatus());

    }


    /*Delete kısmında başarısız sonuç için  negatif bir yanlisDeger olusturuyoruz
    negatif deger girildiğinde idye status kodun 404 olması beklenir...
    Ve bunu test ediyoruz
       */
   @Test
    public void unSuccesfulDelete() throws UnirestException {
       Unirest.setTimeouts(0, 0);
       int yanlisDeger=-1;
       String url="https://petstore.swagger.io/v2/store/order/"+yanlisDeger+"";
       HttpResponse<String> response = Unirest.delete(url)
               .header("accept", "application/json")
               .body("")
               .asString();
       Assert.assertEquals(404,response.getStatus());
    }
}
