import com.thoughtworks.selenium.webdriven.JavascriptLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by ansandu on 11/3/2016.
 */
public class SendEmail {

    private WebDriver driver;

    public SendEmail(WebDriver driver) {
        this.driver = driver;

    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='next']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@id='Passwd']" )
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signIn']")
    private WebElement signInButton;

    @FindBy (xpath = "//div[text() = 'COMPOSE']")
    private WebElement composeButton;

    @FindBy(xpath = "//textarea[@aria-label = 'To']")
    private WebElement toField;

    @FindBy(xpath = "//span[contains(., 'seleniumtest557@gmail.com')]")
    private WebElement fromField;

    @FindBy(xpath = "//input[@name = 'subjectbox']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@aria-label = 'Message Body']")
    private WebElement composeEmail;

    @FindBy(xpath = "//div[@data-tooltip='Attach files']")
    private WebElement attachFiles;

    @FindBy(xpath = "//div[contains(@aria-label,'Send')]")
    private WebElement sendButton;

    @FindBy(xpath = "//a[@class='gb_b gb_db gb_R']/span")
    private WebElement signOutField;

    @FindBy(xpath = "//a[@class='gb_Fa gb_He gb_Oe gb_wb']")
    private WebElement signOutButton;


    public void sendEmail(String usernameField, String passwordField, String toField, String subjectField, String composeEmail ) throws InterruptedException {

        this.usernameField.sendKeys(usernameField);
        this.nextButton.click();
        this.passwordField.sendKeys(passwordField);
        this.signInButton.click();
        this.composeButton.click();
        this.toField.sendKeys(toField);
        Robot robot = null;

        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(5000);
//            //press tab key
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);
//
//            Thread.sleep(5000);
//            //press down
//            robot.keyPress(KeyEvent.VK_DOWN);
//            robot.keyRelease(KeyEvent.VK_DOWN);
//
//            Thread.sleep(5000);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        this.fromField.click();
        List<WebElement> emailList = driver.findElements(By.xpath("//div[contains(@value,'@gmail.com')]"));
        emailList.get(0).click();
        this.subjectField.sendKeys(subjectField);
        this.composeEmail.sendKeys(composeEmail);
        this.attachFiles.click();
        StringSelection ss = new StringSelection("C:\\Users\\ansandu\\IdeaProjects\\temajavaseleniumtraining\\screen.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        if (robot != null) {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }

        this.sendButton.click();
        Thread.sleep(5000);
        this.signOutField.click();
        this.signOutButton.click();




    }














}
