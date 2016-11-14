import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by ansandu on 11/13/2016.
 */
public class PhonePrices {
    private WebDriver driver;

    public PhonePrices(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='product_offers_button']/a")
    private WebElement allShops;

    @FindBy(xpath = "//div[@id='product_offers_container']/ul/li/div[3]/p[1]")
    private List<WebElement> nameList;

    @FindBy(xpath = "//div[@id='product_offers_container']/ul/li/div[2]/div[3]/p[1]/a")
    private List<WebElement> priceList;

    @FindBy(xpath = "//div[@id='product_offers_container']/ul/li/div[2]/div[2]/p[1]/a")
    private List<WebElement> shopsList;

    @FindBy(xpath = "//div[@class = 'l280-i prod-details']/p/span/b")
    private WebElement noShops;

    public void checkOffers()  {


//        Robot robot = null;
//        try {
//        robot = new Robot();
//        robot.keyPress(KeyEvent.VK_PAGE_UP);
//        robot.keyRelease(KeyEvent.VK_PAGE_UP);
//        Thread.sleep(5000);
//            allShops.click();
//
//        } catch (AWTException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //due to the fact that the element get invisible by the menu, I had to scroll up a bit so the elements gets visible
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Actions builder = new Actions(this.driver);

        builder.moveToElement(allShops);
        builder.build().perform();
        js.executeScript("window.scrollBy(0,-500)", "");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        builder.click();
        builder.build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        List<WebElement>shopsList = driver.findElements(By.xpath("//div[@id='product_offers_container']/ul/li/div[2]/div[2]/p[1]/a"));
//        List<WebElement>nameList = driver.findElements(By.xpath("//div[@id='product_offers_container']/ul/li/div[3]/p[1]"));
//        List<WebElement>priceList = driver.findElements(By.xpath("//div[@id='product_offers_container']/ul/li/div[2]/div[3]/p[1]/a"));

        System.out.println(shopsList.size());
        System.out.println(noShops.getText());
        Assert.assertTrue(shopsList.size()== Integer.valueOf(noShops.getText()));

        String minShop = shopsList.get(0).getAttribute("title"), minPrice = priceList.get(0).getText(), maxShop = shopsList.get(0).getAttribute("title"), maxPrice = priceList.get(0).getText();


        for(int i=0; i< nameList.size(); i++){

            if(getFloat(minPrice)<getFloat(priceList.get(i).getText())){
                minPrice = priceList.get(i).getText();
                minShop = shopsList.get(i).getAttribute("title");
            }
            if(getFloat(maxPrice)>getFloat(priceList.get(i).getText())){
                maxPrice = priceList.get(i).getText();
                maxShop = shopsList.get(i).getAttribute("title");
            }


        }

        System.out.println("shop name: " + minShop + " with the minimum price: " +  minPrice);
        System.out.println("shop name: " + maxShop + " with the maximum price: " +  maxPrice);


    }

    public float getFloat(String s){
        return Float.parseFloat(s.trim().replace("RON", "").replace(".", "").replace(",", "."));
    }




}
