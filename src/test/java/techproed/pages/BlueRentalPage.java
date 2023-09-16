package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {


    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//li//a)[1]")
    public WebElement loginButton;

    @FindBy(xpath = "(//input)[1]")
    public WebElement userEmail;

    @FindBy(xpath = "(//button)[3]")
    public WebElement verify;

    //Negative login button
    @FindBy(xpath = "(//button)[2]")
    public WebElement verifyLogin;

    @FindBy(xpath = "(//button)[1]")
    public WebElement profilButton;

    @FindBy(xpath = "//*[.='Profile']")
    public WebElement profile;

    @FindBy(xpath = "//em")
    public WebElement profileEmail;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logout;


    @FindBy(xpath = "//*[.='OK']")
    public WebElement okButton;



    @FindBy(xpath = "//*[.='Bad credentials']")
    public WebElement badCredentialYazisi;
    //select[@name='car']

    @FindBy(xpath = "//select[@name='car']")
    public WebElement carSelectDDM;

    @FindBy(xpath = "//*[@name='pickUpLocation']")
    public WebElement pickUPselectPlace;


    @FindBy(xpath = "(//*[.='Please first login'])[2]")
    public WebElement pleaseFirstLoginText;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement theCarIsNotAvailableText;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement emailMustBeAValidEmail;



    @FindBy(xpath = "//*[.='OK']")
    public WebElement logOutConfirm;



}
