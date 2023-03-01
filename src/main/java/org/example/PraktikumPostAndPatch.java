package org.example;

// Задание
//Тебе нужно обновить информацию о профиле PATCH-запросом на ручку /api/users/me.
//В теле запроса нужно передать такой JSON:
//{
//  "name": "Василий Васильев",
//  "about": "Самый крутой исследователь"
//}
//По условию этот файл хранится в src/test/resources под именем updateProfile.json.
//JSON, который придёт в ответ на корректный вызов, выглядит так:
//{
//  "data": {
//     "name": "Василий Васильев",
//     "about": "Самый крутой исследователь",
//     "avatar": "[https://pictures.s3.yandex.net/resources/jacques-cousteau_1604399756.png](https://pictures.s3.yandex.net/resources/jacques-cousteau_1604399756.png)",
//     "_id": "6162fe1732989c007d63a262",
//     "email": "[e](mailto:dbarshev1@googlemail.com)mail@email.com"
//   }
//}
//Напиши тест, который отправляет PATCH-запрос на ручку /api/users/me и проверяет, что:
//Статус ответа — 200.
//Значения поля name такое же, как имя в JSON-файле.
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class PraktikumPostAndPatch {

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
    }

    @Test
    public void updateProfileAndCheckStatusCode(){
        File file = new File(" src/test/resources");
        Response response = given()
                .header("Content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2RkMjEwMWZkZDQzZTAwM2QxNWNkNTMiLCJpYXQiOjE2NzY4OTcwNjYsImV4cCI6MTY3NzUwMTg2Nn0.CzgFDrPCmaEm8_uPRg9bQ-E6F5cz8xwD1Lr222KNIhI")
                .and()
                .body("Василий Васильев")
                .when()
                .patch("/api/users/me");
        response.then().assertThat()
                .statusCode(200)
                .and()
                .body("data.name", equalTo("Василий Васильев"));
    }
}

