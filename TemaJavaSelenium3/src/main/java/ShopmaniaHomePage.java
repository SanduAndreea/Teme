import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ansandu on 11/9/2016.
 */
public class ShopmaniaHomePage {

    private WebDriver driver;


    public ShopmaniaHomePage(WebDriver driver){
        this.driver = driver;
        this.driver.get("http://www.shopmania.ro/");
    }


    @FindBy(xpath = "//input[@id='autocomplete_prod']")
    private WebElement searchField;

    @FindBy(xpath = "//form[@id='main_search']/div/span[2]/button")
    private WebElement searchButton;

    /**
     * Select the phone name given by parameter
     * @param phoneName
     */


    public void searchPhone (String phoneName)  {

        searchField.sendKeys(phoneName);
        searchButton.click();


    }




}
















