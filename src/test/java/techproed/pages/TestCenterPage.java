package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterPage {
    public TestCenterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//input)[1]")
    public WebElement username;

    @FindBy(xpath = "(//input)[2]")
    public WebElement password;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    // "You logged into a secure area!"  giris basarili testi yapmak icin bu yazinin text' ini aldik
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement verify;
    @FindBy(xpath = "//a//i")
    public WebElement logOut;

    @FindBy(xpath = "//h2")
    public WebElement logOutVerify;


}
