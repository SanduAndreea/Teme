import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by ansandu on 11/9/2016.
 */
public class ShopmaniaTest {

    private WebDriver driver;

    private ShopmaniaHomePage shopmaniaHomePage;
    private ResultPage resultPage;
    private PhoneSelect phoneSelect;
    private PhonePrices phonePrices;



    @Before
    public void before() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        shopmaniaHomePage = PageFactory.initElements(driver, ShopmaniaHomePage.class);
        resultPage = PageFactory.initElements(driver, ResultPage.class);
        phoneSelect = PageFactory.initElements(driver, PhoneSelect.class);
        phonePrices = PageFactory.initElements(driver, PhonePrices.class);


    }

    @After
    public void  After() throws InterruptedException {
       // Thread.sleep(5000);
       // driver.quit();



    }

    @Test
    public void testShopmania()  {

        shopmaniaHomePage.searchPhone("Samsung S7");
        resultPage.selectCategory("Telefoane mobile");
        phoneSelect.checkPrices("Samsung Galaxy S7 Edge");
        phonePrices.checkOffers();






    }





}
