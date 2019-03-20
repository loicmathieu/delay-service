package fr.loicmathieu.delayservice;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DelayServiceRestTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/delay")
          .then()
             .statusCode(200)
             .body(is("OK"));
    }

}