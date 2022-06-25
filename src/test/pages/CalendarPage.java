package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarPage extends BasePage {

    public CalendarPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String[] getStartEndDates() throws ParseException {
        String[] str = new String[2];
        CalendarPage calendarPage = new CalendarPage(driver);
        String startDate = getAttribute(startDatee,"value");
        String endDate = getAttribute(endDatee,"value");

        SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
        Date date = formatter.parse(startDate);
        Date date2 = formatter.parse(endDate);
        str[0] = formatter.format(date); //start date
        str[1] = formatter.format(date2); //End date
        return str;

    }

    @FindBy(xpath = "//div[@class='row'] /h1")
    public WebElement calendarDispalyDate;

    @FindBy(xpath = "//button[text()='Next Month']")
    public WebElement nextMothBtn;

    @FindBy(id = "num-days")
    public WebElement datePcikerMessage;

    @FindBy(xpath = " //div[contains(@class,'day--today')]/following::div[contains(@role,'button')]")
    public WebElement nextDayStartDay;

    @FindBy(xpath = "//div[contains(@class,'day--today')]/following::div[contains(@role,'button')][3]")
    public WebElement threeDayAheadEndDate;

    @FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[1]//input")
    public WebElement startDatee;

    @FindBy(xpath = "(//div[@class='react-datepicker__input-container'])[2]//input")
    public WebElement endDatee;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[contains(@class,'month-container')]")
    public WebElement monthContainer;
}
//div[@class='react-datepicker__month-container']