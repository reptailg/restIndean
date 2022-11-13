package studentapp.test;

import com.github.javafaker.Faker;
import data.Student;
import data.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

class CreateStudentTest extends TestBase {

    @DisplayName("Create new student")
    @Test
    void createStudentTest(){

        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student().fakeStudent())
                .post()
                .then().log().all()
                .statusCode(201);
    }

}
