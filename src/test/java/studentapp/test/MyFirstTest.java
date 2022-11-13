package studentapp.test;

import data.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

class MyFirstTest extends TestBase {

//    private String uri = TestConfig.URI.value;

    private void styles(){

        given()
                .queryParam("","")
                .when()
                .get("https://google.com/")
                .then();

        given()
                .expect()
                .when();
    }

    @DisplayName("Getting all students")
    @Test
    void getAllStudents(){

//        RequestSpecification requestSpec = RestAssured.given();
//        Response response = requestSpec.get("http://localhost:8085/student/list");
//        response.prettyPrint();
//
//        ValidatableResponse validatableResponse = response.then();
//
//        validatableResponse.statusCode(200);

        given()
                .queryParam("","")
                .when()
                .get("/list")
                .then()//.log().all()
                .statusCode(200);

        given()
                .expect()
                .statusCode(200)
                .when()
                .get("/list");

        given()
                .when()
                .get("/list")
                .then()//.log().all()
                .statusCode(200);

    }

    @DisplayName("Getting students with filter")
    @Test
    void getfilteredStudents(){

        Map<String, Object> params = new HashMap<>();
        params.put("programme","Financial Analysis");
        params.put("limit", 1);
        Response response= given()
                //.queryParams("programme","Financial Analysis", "limit", 1)
                .queryParams(params)
                .when()
                .get("/list");
        response.prettyPrint();
    }

    @DisplayName("Getting single student")
    @Test
    void getSingleStudent(){

        Response response= given()
                .when()
                //.pathParam("id", 2)
                .get("/{id}",2);
        response.prettyPrint();

    }
}
