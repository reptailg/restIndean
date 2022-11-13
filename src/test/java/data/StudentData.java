package data;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class StudentData {

    private StudentData(){
    }

    public static Object[][] createGuestPositive(){
        return new Object[][]{
                {Student.defaultof()},
//                {Student.defaultof().setFirstname(RandomStringUtils.randomAlphabetic(3))},
//                {Student.defaultof().setLastname(RandomStringUtils.randomAlphabetic(3))},
//                {Student.defaultof().setTotalprice(0)},
//                {Student.defaultof().setDepositpaid(false)},
//                {Student.defaultof().setBookingdates(date().toString(), date().toString())},
//                {Student.defaultof().setAdditionalneeds(RandomStringUtils.randomAlphabetic(20))},
        };
    }

    public static LocalDate date() {
        int hundredYears = 100 * 365;
        return LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, hundredYears));
    }
}
