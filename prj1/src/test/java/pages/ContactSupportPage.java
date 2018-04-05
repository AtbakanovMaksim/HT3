package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSupportPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://help.github.com/";

    @FindBy(xpath = "//input[@id='form_name'][@type='text']")
    private WebElement nameForm;

    @FindBy(xpath = "//select[@id='form_email']")
    private WebElement emailForm;

    @FindBy(xpath = "//input[@id='form_subject'][@type='text']")
    private WebElement subjectForm;

    @FindBy(xpath = "//textarea[@id='form_comments']")
    private WebElement textForm;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement attachForm;

    @FindBy(xpath = "//button[@class='btn btn-primary'][@type='submit']")
    private WebElement submitButton;

    public ContactSupportPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Help page opened");
    }

    public WebElement getNameForm() {
        return nameForm;
    }

    public WebElement getEmailForm() {
        return emailForm;
    }

    public WebElement getSubjectForm() {
        return subjectForm;
    }

    public WebElement getTextForm() {
        return textForm;
    }

    public WebElement getAttachForm() {
        return attachForm;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
