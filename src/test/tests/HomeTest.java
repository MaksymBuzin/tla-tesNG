package tests;

import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.SeleniumUtils;

import java.util.List;

public class HomeTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
    }


    @Test(testName = "LP-1 home page header", description = "Verify home page header is Automation with Selenium")
    public void test01() {
         Assert.assertEquals("Automation with Selenium",homePage.getText(homePage.headerText));
    }


    @Test(testName = "LP -2 PHP Travels Link", description ="Verify the PHP Travels Link takes to the correct page (verify title)",dataProvider = "homePageLinkTitles",dataProviderClass = DataProviders.class)
    public void test02(String title) throws InterruptedException {
        homePage.click(homePage.phpTravelsLink);
        Assert.assertEquals(title,SeleniumUtils.switchToWindowAndVerifyTitle(getDriver()));
    }

    @Test(testName = "LP -2 Mercury tours", description ="Verify the Mercury tours Link takes to the correct page (verify title)",dataProvider = "homePageLinkTitles",dataProviderClass = DataProviders.class)
    public void test03(String title) throws InterruptedException {
        homePage.click(homePage.mercuryToursLink);
        Assert.assertEquals(SeleniumUtils.switchToWindowAndVerifyTitle(getDriver()),title,"pass");

    }
    @Test(testName = "LP -2 Internet", description ="Verify the Internet Link takes to the correct page (verify title)",dataProvider = "homePageLinkTitles",dataProviderClass = DataProviders.class)
    public void test04(String title) throws InterruptedException {
        homePage.click(homePage.internetLink);
        Assert.assertEquals(SeleniumUtils.switchToWindowAndVerifyTitle(getDriver()),title,"pass");

    }

}
