package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OnlineVerifyEmailPage {
    public OnlineVerifyEmailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[.='Login to billing account']" )
    public WebElement loginButton ;

    @FindBy(xpath = "//*[@name='username']" )
    public WebElement usernameOrEmail ;



}
