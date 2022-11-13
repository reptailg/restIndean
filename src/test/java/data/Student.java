package data;

import com.github.javafaker.Faker;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;


    public Student defaultof(){
        return new Student("Test",
                "Test",
                "test@Duisac.net",
                "Computer Science",
                Arrays.asList("C++","Map Basic")
                );
    }
    public Student fakeStudent(){
        Faker faker = new Faker();
        return new Student(faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),"Computer Science",
                Arrays.asList("C++","Map Basic"));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
