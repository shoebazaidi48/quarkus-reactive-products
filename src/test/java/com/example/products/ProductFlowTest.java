package com.example.products;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ProductFlowTest {
    @Test
    void postProduct() {
        String productJson = "{\n" +
                "  \"id\": \"p-1\",\n" +
                "  \"name\": \"Notebook\",\n" +
                "  \"category\": \"Books\",\n" +
                "  \"price\": 12.99\n" +
                "}";

        given()
            .contentType(ContentType.JSON)
            .body(productJson)
        .when()
            .post("/products")
        .then()
            .statusCode(202);
    }
}
