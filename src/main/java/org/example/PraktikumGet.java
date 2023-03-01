package org.example;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import io.restassured.response.Response;
// дополнительный импорт статический нужен, чтобы использовать given,get, then
import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
public class PraktikumGet {

    // Анотация Before показывает, что метод будет выполняться перед каждым тестовым методом

    @Before
    public void setUp() {
        // повторяющуюся для разных ручек часть урла лучше записать в переменную в методе Бефор
        // если в классе будет несколько тестов, указывать ее придется только один раз
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru/";
    }

    // создаем метод автотеста
    // это get запросы
    @Test
    public void getMyInfoStatusCode() {
        // метод given помогает сформировать запрос
        Response response = given().
                // указываем протокол и данные авторизации
                        auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2RkMjEwMWZkZDQzZTAwM2QxNWNkNTMiLCJpYXQiOjE2NzY4OTcwNjYsImV4cCI6MTY3NzUwMTg2Nn0.CzgFDrPCmaEm8_uPRg9bQ-E6F5cz8xwD1Lr222KNIhI")
                .get("data.about");
        response.then().assertThat().body("Занятие» — «Автор автотестов>>", equalTo(11));

        System.out.println(response.body().asString());

    }
}