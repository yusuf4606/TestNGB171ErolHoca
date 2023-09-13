package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//input)[2]")
    public WebElement userName;
    @FindBy(xpath = "(//input)[3]")
    public WebElement password;
    @FindBy(xpath = "//button")
    public WebElement loginButton;

    // DashBoard WebElementi
    @FindBy (xpath = "//h6")
    public WebElement verify;

}
