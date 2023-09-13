package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AmazonPage {

    /*
        TestNG frameworkünde locate'lerimizi page class'larında tutarız. TestNG frameworkünde artık findElement()
     methodu yerine @FindBy notasyonu kullanırız. Ve findElement() methodunu nasıl driver ile kullandıysak
     Bu class'da da driver'i tanımlamamız gerekiyor. Bunun için PageFactory class'ından initElements()
     methodu ile aşağıdaki örnekteki gibi driver'i bu class'a tanımlarız. @FindBy notasyonu kullanımında
     notasyona parametre olarak locator'i ve değerini yazarız. Sonra da locatini aldığımız webelemente bir
     isim veririz
     */
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "twotabsearchtextbox")
    public WebElement aramaKutusu;
}
