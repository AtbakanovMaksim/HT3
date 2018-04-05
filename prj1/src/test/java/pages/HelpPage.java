package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://help.github.com/";

    @FindBy(xpath = "//a[contains(text(), 'Supported browsers')]")
    private WebElement supportedBrowsersLink;
    @FindBy(xpath = "//div[@id='header']//a[contains(text(), 'Contact Support')]")
    private WebElement contactSupportButton;


    public HelpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Help page opened");
    }

    public void openSupportedBrowsersLink() {
        supportedBrowsersLink.click();
    }

    public void clickContactSupport() {
        contactSupportButton.click();
    }

}
