package dev.christianpetzold.api;

import dev.christianpetzold.application.GameApplication;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@QuarkusTest
class GameResourceTest {

    @TestHTTPEndpoint(GameResource.class)
    @TestHTTPResource
    URL url;

    @InjectSpy
    GameApplication gameApplication;

    @Test
    void getRandomPlayerGuessingInfo_Successful() {


        given()
                .when()
                .get(url + "/guess")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("json_schemas/playerGuessingInfo.json"));
    }
}