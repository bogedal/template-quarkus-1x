package dk.bankdata.template.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ApiResourceTest {

    @Test
    public void testTemplateNameEndpoint() {
        given()
          .when().get("/template/name")
          .then()
             .statusCode(200)
             .body(is("template-java-quarkus-1x"));
    }

}