package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Calendar")
    public WebElement calendarLinkBtn;

    @FindBy(className = "header-text")
    public WebElement headerText;

    @FindBy(id = "php-travels")
    public WebElement phpTravelsLink;

    @FindBy(id = "mercury-tours")
    public WebElement mercuryToursLink;

    @FindBy(id = "internet")
    public WebElement internetLink;
}
