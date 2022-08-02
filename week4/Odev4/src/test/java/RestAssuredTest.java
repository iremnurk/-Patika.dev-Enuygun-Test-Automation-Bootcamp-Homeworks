import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RestAssuredTest {   //Rest Assured Kütüphanesi ile API Testlerinin Otomasyonu
    @Test
    public void testFirstPostMethod(){
        //x diye string bir değişken tanımladık ve body ye göndermek istediğimiz verilerimizi içine koyduk.
        String x="{\"id\": 1,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2022-07-29T13:06:12.277Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true}";

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        Response res=given()    //Response res in içine Postmande manuel olarak yaptığımız işleri kodun içinde doldurduk.
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .body(x)                           //Oluşturduğumuz x değişkeni body nin içine koyduk.
                .log().all()                        //.log().all() diyerek ayrıntılı bir şekilde response dönmesini istedik
                .request("POST","/store/order") // satırında ise birinci parametremiz request tipi,
                                                      //ikinci parametremiz ise post etmek istediğimiz url path miz oldu.
                .then().extract().response();

        String res2=res.asString();
        System.out.println(res2);

    }

    @Test
    public void unsSuccessfultestFirstPostMethod(){
        String x="{\"id\": z,\n" +
                "  \"petId\": 0,\n" +
                "  \"quantity\": 0,\n" +
                "  \"shipDate\": \"2022-07-29T13:06:12.277Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true}";

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        Response res=given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .body(x)
                .log().all()
                .request("POST","/store/order")
                .then().extract().response();
        String res2=res.asString();
        System.out.println(res2);
        /*
        yukarıda yaptıpımız işlemleri başarısız test koşumumuz içinde yaptık fakat başarısız dönmesi için id değeri
        sayılardan oluşmalı ama biz char şeklinde 'z' harfi gönderdik ve {"code":400,"type":"unknown","message":"bad input"}
        çıktısını aldık
         */
    }
    @Test
    public void successfulTestSecondGetMethod(){
        // Bu isteğimiz Get requesti olduğu için Body yi kullanmayacağız.
        RestAssured.baseURI="https://petstore.swagger.io/v2/store/order/1";
        Response res=
                when().
                        get().
                        then().
                        extract().
                        response();
        String res3=res.asString();   //response- cevabı
        System.out.println(res3);    //sistemin yanıtını ekrana yazdır

    }
    @Test
    public void unSuccessfulTestSecondGetMethod(){

        RestAssured.baseURI="https://petstore.swagger.io/v2/store/order/10"; //Geçerli yanıt için ID değeri >=1 ve <=10

        Response res=
                when().
                        get().
                        then().
                        extract().
                        response();
        String res3=res.asString();   //response- cevabı
        System.out.println(res3);    //sistemin yanıtını ekrana yazdır 404 status kod hatası alınır..

    }




}
