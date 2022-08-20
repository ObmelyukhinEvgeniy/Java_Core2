package Lesson7;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

    public class Main {
        public static void main(String[] args) throws IOException {

            RestAssured.baseURI = "http://dataservice.accuweather.com/";
            Response response = given()
                    .when()
                    .get("forecasts/v1/daily/5day/295212?apikey=tbSZ9aDAMKYPHkJ0oqZ1AnEDVVK4vI95");



            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode = objectMapper
                    .readTree(response.asPrettyString())
                    .at("/DailyForecasts");

            List<DailyForecasts> dailyForecasts = new ArrayList<>();

            if(jsonNode.isArray()) {
                for (JsonNode arrayNode : jsonNode) {
                    dailyForecasts.add(objectMapper.convertValue(arrayNode, DailyForecasts.class));
                }
            }

            for (DailyForecasts dailyForecast : dailyForecasts) {
                System.out.println("В городе Санкт-Петербург на дату: " + dailyForecast.getDate()
                        + " ожидается - " + dailyForecast.getDay().getIconPhrase()
                        + ", максимальная температура = " + dailyForecast.getTemperature().getMaximum().getValue()
                        + "C , минимальная температура = " + dailyForecast.getTemperature().getMinimum().getValue()
                        + "C");
            }

//            System.out.println(response.asPrettyString());
        }
    }


