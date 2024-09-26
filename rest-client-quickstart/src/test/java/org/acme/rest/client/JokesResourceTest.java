package org.acme.rest.client;

import io.quarkus.test.common.WithTestResource;
import io.quarkus.test.junit.QuarkusTest;

import org.acme.rest.client.resources.WireMockExtensions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
@WithTestResource(WireMockExtensions.class)
public class JokesResourceTest {


    @Test
    public void testJokesApi() {
        given()
                .when().get("/jokes/5")
                .then()
                .statusCode(200)
                .body("$.size()", is(5));
    }

    @Test
    public void testJokesApiWithInvalidId() {
        given()
                .when().get("/jokes/abc")
                .then()
                .statusCode(404);
    }

    @Test
    public void testJokesApiWithIdGreaterThan10() {
        given()
                .when().get("/jokes/15")
                .then()
                .statusCode(204);
    }

    @Test
    public void testJokesApiWithIdLessThanOrEqualTo0() {
        given()
                .when().get("/jokes/0")
                .then()
                .statusCode(500);
    }
}
