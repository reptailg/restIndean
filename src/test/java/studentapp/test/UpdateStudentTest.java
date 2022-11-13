package studentapp.test;

import com.github.javafaker.Faker;
import data.Student;
import data.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

class UpdateStudentTest extends TestBase {

    @DisplayName("Update all field student")
    @Test
    void updateAllTest(){
        int id = new Random().nextInt(100);
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student().fakeStudent())
                .put("/{id}",id)
                .then()//.log().all()
                .statusCode(200);
        System.out.println("Student #" + id + " updated!");
    }

    @DisplayName("Update student's email")
    @Test
    void updateStudent(){
        Student student = new Student();
        Faker faker = new Faker();
        int id = new Random().nextInt(100);

        given()
                .when()
                .get("/{id}",id)
                        .then().log().all();
        student.setEmail(faker.internet().emailAddress());
        System.out.println(student.getEmail());
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("/{id}",id)
                .then()//.log().all()
                .statusCode(200);
        System.out.println("Student's #" + id + " email updated!");
        given()
                .when()
                .get("/{id}",id)
                .then().log().all();

    }

    @DisplayName("Delete student")
    @Test
    void deleteStudent(){

        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .body(student().fakeStudent())
                .post()
                .then().log().all()
                .extract().response();

        int id = Integer.parseInt(response.header("Location")
                .substring(response.header("Location").length()-3));

        System.out.println("Create student #"+ id + "!");

        given()
                .when()
                .contentType(ContentType.JSON)
                .delete("/{id}", id)
                .then().log().all()
                .statusCode(204);

        given()
                .when()
                .get("/{id}",id)
                .then().log().all()
                .statusCode(404);
        System.out.println("Delete student #" + id);
    }


}
