package data;

import io.restassured.RestAssured;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    private String string;
    private static Process process;

    //@NotNull
    public static Property property() {
        return new Property();
    }

    public Student student(){
        return new Student();
    }

    @SneakyThrows
    @BeforeAll
    public static void initSpringBoot() {
        String filePath = "src/test/resources/rest.jar";
        process =
        Runtime.getRuntime().exec("java -jar " + filePath + " --server.port=" + property().getProperty("port"));
        Thread.sleep(15000);
    }
    @BeforeAll
    public static void initRestAssured(){
        RestAssured.reset();
        RestAssured.baseURI = property().getProperty("uri");
        RestAssured.port = Integer.parseInt(property().getProperty("port"));
        RestAssured.basePath = property().getProperty("path");
    }

    @SneakyThrows
    @AfterAll
    public static void closedAll(){
        process.destroy();
        RestAssured.reset();
    }
}
