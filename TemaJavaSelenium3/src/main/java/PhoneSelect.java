import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by ansandu on 11/11/2016.
 */
public class PhoneSelect {

    private WebDriver driver;

    public PhoneSelect(WebDriver driver) {

        this.driver = driver;
    }


    @FindBy(xpath = "//p[@class = 'text-xl']/a")
    private List<WebElement> nameList;

    @FindBy(xpath = "//a[@class='price-offer']")
    private List<WebElement> priceList;

    @FindBy(xpath = "//a[@class = 'btn']")
    private List<WebElement> offersList;

    /**
     * Finds the first matching element and performs a click on it
     * @param selectSamsungedge - value of the searched item(phone)
     */

    public void checkPrices(String selectSamsungedge) {



         for(int i=0; i< nameList.size(); i++){
             if (nameList.get(i).getText().contains(selectSamsungedge)) {

                 nameList.get(i).click();
                 break;


             }
         }



    }













}
