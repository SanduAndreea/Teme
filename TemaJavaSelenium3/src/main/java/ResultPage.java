import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Created by ansandu on 11/9/2016.
 */
public class ResultPage {


    private WebDriver driver;
    private PhoneSelect phoneSelect;


    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='main_col']/div/ul[1]/li/a")
    private List<WebElement>categoryList;

    /**
     * Select the category name given by parameter
     * @param categoryName
     */


    public PhoneSelect selectCategory (String categoryName) {


        for (WebElement categ : categoryList ){
            if(categ.getText().equals(categoryName)) {
                categ.click();
                PhoneSelect phoneSelect = PageFactory.initElements(driver, PhoneSelect.class);
                return phoneSelect;


            }

        }
        fail("No category was find with name " + categoryName);
        return null;



    }


}
