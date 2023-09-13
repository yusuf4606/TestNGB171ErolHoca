package techproed.tests.day18_Annotation;

import org.testng.annotations.*;

public class C01_Notasyonlar {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Herşeyden önce BeforeSuite notasyonuna sahip method 1 kez çalışır");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden önce BeforeTest notasyonuna sahip method 1 kez çalışır");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her class'dan önce BeforeClass notasyonuna sahip method 1 kez çalışır");
        System.out.println("*********************************************************************");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Her method dan önce 1 kez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("test01 çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("test02 çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("test03 çalıştı");
    }
}
