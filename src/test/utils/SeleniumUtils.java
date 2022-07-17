package utils;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class SeleniumUtils {


    public static String getTodaysDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");  //get today's date in speciphic format
        Date date = new Date();
        return formatter.format(date);

    }

    public static String switchToWindowAndVerifyTitle(WebDriver driver) throws InterruptedException {
        String currentWindowID = driver.getWindowHandle();
        String title = "";

        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String each: allWindowIDs){
            if (!each.equals(currentWindowID)){

                driver.switchTo().window(each);
               Thread.sleep(500);
                title = driver.getTitle();
                driver.close();
            }
        }

        driver.switchTo().window(currentWindowID);
        return title;
    }

}
