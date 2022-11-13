package data;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    public Student(Student student) {
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.email = student.email;
        this.programme = student.programme;
        this.courses = student.courses;
    }
    public static Student defaultof(){
        return new Student("Test",
                "Test",
                "test@Duisac.net",
                "Computer Science",
                Arrays.asList("C++","Map Basic")
                );
    }

}
