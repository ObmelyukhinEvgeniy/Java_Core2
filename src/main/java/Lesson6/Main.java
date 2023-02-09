package Lesson6;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class Main {
    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "http://dataservice.accuweather.com/";
        Response response = given()
                .when()
                .get("forecasts/v1/daily/5day/295212?apikey=tbSZ9aDAMKYPHkJ0oqZ1AnEDVVK4vI95");
        if(response.getStatusCode() == 200) {
            System.out.println("Тест успешно пройден!");
        } else {
            System.out.println("Произошла ошибка!");
        }
        System.out.println(response.asPrettyString());

    }
}
