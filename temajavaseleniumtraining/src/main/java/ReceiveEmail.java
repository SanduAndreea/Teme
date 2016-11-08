import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ansandu on 11/7/2016.
 */
public class ReceiveEmail {

    private WebDriver driver;

    public ReceiveEmail(WebDriver driver) {
        this.driver = driver;

    }
    @FindBy(id = "account-chooser-link")
    private WebElement addAccount;

    @FindBy(id = "account-chooser-add-account")
    private WebElement addAccountButton;


    @FindBy(xpath = "//input[@id='Email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='next']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='Passwd']" )
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signIn']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[contains(., 'Screenshot cel.ro')]")
    private WebElement openEmail;

    @FindBy(xpath = "//div[@aria-label='Download attachment screen.png']/div")
    private WebElement downloadImage;


    public void receiveEmail(String usernameField, String passwordField)throws InterruptedException {
        this.addAccount.click();
        this.addAccountButton.click();
        this.usernameField.sendKeys(usernameField);
        this.nextButton.click();
        this.passwordField.sendKeys(passwordField);
        this.signInButton.click();
        this.openEmail.click();
        this.downloadImage.click();







    }









    }
