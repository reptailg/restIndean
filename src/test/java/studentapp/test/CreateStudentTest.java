package studentapp.test;

import data.Student;
import data.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

class CreateStudentTest extends TestBase {

    @DisplayName("Create new student")
    @Test
    void createStudentTest(){
//        String student = "{\n" +
//                "\"firstName\": \"Test\",\n" +
//                "\"lastName\": \"Test\",\n" +
//                "\"email\": \"test@Duisac.net\",\n" +
//                "\"programme\": \"Computer Science\",\n" +
//                "\"courses\": [\n" +
//                "\"C++\",\n" +
//                "\"Map Basic\"\n" +
//                "]\n" +
//                "}";

        Student student = new Student("Test","Test","test1@Duisac.net","Computer Science",
                Arrays.asList("C++","Map Basic"));
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()//.log().all()
                .statusCode(201);
    }

}
