package techproed.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /*
    .properties uzantili dosyadaki dataları test class'ımızda okuyabilmemiz için return type'ı String
olan bir parametreli static method oluştururuz ve bu method içinde Properties class'ından bir obje oluştururuz.
Sonra FileInputStream ile bu dosyayı akışa alır Properties class'ından oluşturmuş olduğumuz objeye load()
methodu ile yükleriz. Son olarak olusturmus oldugumuz obje ile getProperty() methodunu kullanarak method icine parametre olarak girilen key'in degerini bize return eder.
 */

    public static String getProperty(String key){
        Properties properties = new Properties();
        String dosyaYolu = "configuration.properties";


        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties.getProperty(key);
    }
}
