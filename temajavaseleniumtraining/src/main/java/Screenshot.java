import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by ansandu on 11/3/2016.
 */
public class Screenshot {

    private WebDriver driver;

    public Screenshot(String url, WebDriver driver){
        this.driver = driver;
        this.driver.get(url);
    }


    public Integer takeScreenshot(String pathToFile) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screen = ts.getScreenshotAs(OutputType.FILE);
        Integer resultStatus = 0;

        try {
            FileUtils.copyFile(screen, new File(pathToFile));
            resultStatus = 1;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStatus;
    }
}
