package techproed.tests.day21_SmokeTest_Excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C03_ExcelTest {
    @Test
    public void excelTest() {

        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaismi = "customer_info";

        ExcelReader reader = new ExcelReader(dosyaYolu,sayfaismi);
        reader.getCellData(1,0);

        String email = reader.getCellData(1,0);
        String password = reader.getCellData(1,1);
        System.out.println(email + " || "+ password);


    }
}
