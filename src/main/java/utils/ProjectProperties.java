package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProperties {

    public static Properties properties = readProperties();

    //fixed todo  метод хороший, но место у него не то. перенеси в utils.ProjectProperties
    //fixed todo ответь себе на ворпос и мне  ;) как часть будет открываться этот файлик при такой реализации
    //а сколько раз он должен открываться?

    //При такой реализации он будет открываться каждый раз, когда мы захотим забрать из него какую-нибудь пропертю,
    //а должен открываться, наверное, как можно меньше раз, а лучше один) Исправила.
    private static Properties readProperties() {

        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("./src/test/resources/properties/test.properties")) {
            if (input == null) {
                System.out.println("test.properties file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e);
        }

        return properties;
    }
}
