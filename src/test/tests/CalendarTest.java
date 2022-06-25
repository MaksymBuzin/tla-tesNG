package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.HomePage;
import utils.SeleniumUtils;

import java.text.ParseException;

public class CalendarTest extends BaseTest {
    HomePage homePage;
    CalendarPage calendarPage;
    BasePage basePage;

    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
        calendarPage = new CalendarPage(getDriver());
    }

    @Test(testName = "BF-1  - calendar Date", description = "calendar should displays correct date", priority = 0)
    public void test01() {
        homePage.click(homePage.calendarLinkBtn);
        String date = SeleniumUtils.getTodaysDate();
        String calendarDate = calendarPage.getText(calendarPage.calendarDispalyDate);

        Assert.assertEquals(date, calendarDate);


    }

    @Test(testName = "BF-2 - start date drop down calendar", description = "verify drop down calendar is available for start date", priority = 1)
    public void test02() {
        homePage.click(homePage.calendarLinkBtn);
        calendarPage.click(calendarPage.startDatee);
        Assert.assertTrue(calendarPage.isDisplayed(calendarPage.monthContainer));
    }

    @Test(testName = "BF-3 - end date drop down calendar", description = "verify drop down calendar is available for end date", priority = 2)
    public void test03() {
        homePage.click(homePage.calendarLinkBtn);
        calendarPage.click(calendarPage.endDatee);
        Assert.assertTrue(calendarPage.isDisplayed(calendarPage.monthContainer));
    }
    @Test(testName = "BF - 4 - submit button",description = "verify submit btn is clickable",priority = 3)
    public void test04(){
        homePage.click(homePage.calendarLinkBtn);
        Assert.assertTrue(calendarPage.isDisplayed(calendarPage.submitBtn));

    }


    @Test(testName = "BF -5 - date picker message", description = "verify message displays correct data", priority = 4)
    public void test05() throws ParseException {
        homePage.click(homePage.calendarLinkBtn);
        calendarPage.click(calendarPage.startDatee);
        calendarPage.click(calendarPage.nextDayStartDay);
        calendarPage.click(calendarPage.endDatee);
        calendarPage.click(calendarPage.threeDayAheadEndDate);
        calendarPage.click(calendarPage.submitBtn);

        String dates[] = calendarPage.getStartEndDates();//call method
        String expectedRes = "There are 2 days between " + dates[0] + " and " + dates[1];

        Assert.assertEquals(expectedRes, calendarPage.getText(calendarPage.datePcikerMessage));

    }

}
