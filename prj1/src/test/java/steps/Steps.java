package steps;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class Steps {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public void loginGithub(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {
        LoginPage loginPage = new LoginPage(driver);
        String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
        logger.info("Actual username: " + actualUsername);
        return actualUsername.equals(username);
    }

    public boolean createNewRepository(String repositoryName, String repositoryDescription) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCreateNewRepositoryButton();
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
        return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
    }

    public boolean currentRepositoryIsEmpty() {
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        return createNewRepositoryPage.isCurrentRepositoryEmpty();
    }

    public void callHelpPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHelp();
    }

    public void learnSupportedBrowser() {
        HelpPage helpPage = new HelpPage(driver);
        helpPage.openSupportedBrowsersLink();
        SupportedBrowserPage browserPage = new SupportedBrowserPage(driver);
    }

    public void contackSupport() {
        HelpPage helpPage = new HelpPage(driver);
        helpPage.clickContactSupport();
    }

    public boolean isChromeSupported() {
        SupportedBrowserPage browserPage = new SupportedBrowserPage(driver);
        try {
            browserPage.getChromeInfo().isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isFirefoxSupported() {
        SupportedBrowserPage browserPage = new SupportedBrowserPage(driver);
        try {
            browserPage.getFirefoxInfo().isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isExplorerSupported() {
        SupportedBrowserPage browserPage = new SupportedBrowserPage(driver);
        try {
            browserPage.getExplorerInfo().isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isMSEdgeSupported() {
        SupportedBrowserPage browserPage = new SupportedBrowserPage(driver);
        try {
            browserPage.getEdgeInfo().isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSafariSupported() {
        SupportedBrowserPage browserPage = new SupportedBrowserPage(driver);
        try {
            browserPage.getSafariInfo().isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isOperaSupported() {
        SupportedBrowserPage browserPage = new SupportedBrowserPage(driver);
        try {
            browserPage.getOperaInfo().isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isNameFormDisplayed() {
        ContactSupportPage contactSupportPage = new ContactSupportPage(driver);
        return contactSupportPage.getNameForm().isDisplayed();
    }

    public boolean isEmailFormDisplayed() {
        ContactSupportPage contactSupportPage = new ContactSupportPage(driver);
        return contactSupportPage.getEmailForm().isDisplayed();
    }

    public boolean isSubjectFormDisplayed() {
        ContactSupportPage contactSupportPage = new ContactSupportPage(driver);
        return contactSupportPage.getSubjectForm().isDisplayed();
    }

    public boolean isTextFormDisplayed() {
        ContactSupportPage contactSupportPage = new ContactSupportPage(driver);
        return contactSupportPage.getTextForm().isDisplayed();
    }

    public boolean isAttachFormDisplayed() {
        ContactSupportPage contactSupportPage = new ContactSupportPage(driver);
        return contactSupportPage.getAttachForm().isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {
        ContactSupportPage contactSupportPage = new ContactSupportPage(driver);
        return contactSupportPage.getSubmitButton().isDisplayed();
    }

    public void searchFirstRepo() {
        MainPage mainPage = new MainPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 3, 1000);
        mainPage.getSearchForm().sendKeys(mainPage.getFirstRepo().getAttribute("text").trim());
        wait.until(ExpectedConditions.invisibilityOf(mainPage.getSecondRepo()));

    }

    public boolean isFirstRepoLinkVisible() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getFirstRepo().isDisplayed();
    }

    public boolean isSecondRepoLinkVisible() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getSecondRepo().isDisplayed();
    }

    public boolean isThirdRepoLinkVisible() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getThirdRepo().isDisplayed();
    }
}
