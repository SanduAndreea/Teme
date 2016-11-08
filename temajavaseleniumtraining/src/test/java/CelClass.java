import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by ansandu on 11/1/2016.
 */
public class CelClass {

    private WebDriver driver;

    private SendEmail sendEmail;

    private ReceiveEmail receiveEmail;

    @Before
    public void Before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ansandu\\drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sendEmail = PageFactory.initElements(driver, SendEmail.class);
        receiveEmail = PageFactory.initElements(driver, ReceiveEmail.class);

    }

    @After
    public void After() throws InterruptedException {
//       Thread.sleep(5000);
//       driver.quit();


    }

    @Test
    public void Test() throws InterruptedException {
        String pathToFile = "screen.png";
        String urlCel ="http://www.cel.ro/";
        Screenshot screenshot = new Screenshot(urlCel, driver);
        assertTrue(screenshot.takeScreenshot(pathToFile) == 1);
        driver.navigate().to("https://gmail.com");
        sendEmail.sendEmail("seleniumtest557@gmail.com", "pass1122", "seleniumtest579@gmail.com", "Screenshot cel.ro", "I've attached the screenshot of the cel.ro site");
        receiveEmail.receiveEmail("seleniumtest579@gmail.com", "test1122");








    }





}
