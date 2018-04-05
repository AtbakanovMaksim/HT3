package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupportedBrowserPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://help.github.com/";

    @FindBy(xpath = "//a[contains(text(), 'Chrome')]")
    private WebElement chromeInfo;

    @FindBy(xpath = "//a[contains(text(), 'Firefox')]")
    private WebElement firefoxInfo;

    @FindBy(xpath = "//a[contains(text(), 'Safari')]")
    private WebElement safariInfo;

    @FindBy(xpath = "//a[contains(text(), 'Microsoft Edge')]")
    private WebElement edgeInfo;

    @FindBy(xpath = "//a[contains(text(), 'Internet Explorer')]")
    private WebElement explorerInfo;

    @FindBy(xpath = "//a[contains(text(), 'Opera')]")
    private WebElement operaInfo;

    public SupportedBrowserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Help page opened");
    }

    public WebElement getChromeInfo() {
        return chromeInfo;
    }

    public WebElement getFirefoxInfo() {
        return firefoxInfo;
    }

    public WebElement getSafariInfo() {
        return safariInfo;
    }

    public WebElement getEdgeInfo() {
        return edgeInfo;
    }

    public WebElement getExplorerInfo() {
        return explorerInfo;
    }

    public WebElement getOperaInfo() {
        return operaInfo;
    }
}
