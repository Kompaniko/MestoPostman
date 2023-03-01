package org.example;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProfileTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }
    @Test
    public void updateProfile() {
        Profile profile = new Profile("Аристарх Сократович", "Автор автотестов");
        given().header("Content-type", "application/json")
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2M2RkMjEwMWZkZDQzZTAwM2QxNWNkNTMiLCJpYXQiOjE2NzY4OTcwNjYsImV4cCI6MTY3NzUwMTg2Nn0.CzgFDrPCmaEm8_uPRg9bQ-E6F5cz8xwD1Lr222KNIhI")
                .body(profile)
                .patch("/api/users/me");
    }
}
