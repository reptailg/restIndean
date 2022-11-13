package data;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

    @SneakyThrows
    public String getProperty(String prop){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("File 'config.properties' not found");
        }
        return properties.getProperty(prop);
    }

}
