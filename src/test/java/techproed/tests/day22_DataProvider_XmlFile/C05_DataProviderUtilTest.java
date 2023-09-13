package techproed.tests.day22_DataProvider_XmlFile;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtil;

public class C05_DataProviderUtilTest {






    @Test(dataProvider = "isimler",dataProviderClass = DataProviderUtil.class)
    public void test01(String data) {
        System.out.println(data);
    }

    /*
    Test class'larımızda sadece test methodlarımızın olmasını istediğimiz için, DataProvider kullanırken yukarıdaki
örnekteki gibi dataprovider parametresinden sonra dataProviderClass parametresi sayesinde belitmiş olduğumuz
class ismi ile @DataProvider notasyonuna sahip methodu oluşturabiliriz. Böylece test class'ımızda
sadece test methodlarımız olmuş olucak ve kullanıcı bilgileri görülmemiş olucak.
 */
}
