package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private final String BASE_URL = "https://github.com/";

    @FindBy(xpath = "//a[contains(@aria-label, 'Create new')]")
    private WebElement buttonCreateNew;

    @FindBy(xpath = "//a[contains(text(), 'New repository')]")
    private WebElement linkNewRepository;

    @FindBy(xpath = "//div[contains(@class, 'footer container')]//a[contains(text(), 'Help')]")
    private WebElement helpLink;

    @FindBy(xpath = "//div[@id='your_repos']//input[@type='text']")
    private WebElement searchForm;
    @FindBy(xpath = "//ul[contains(@class,'mini-repo-list')]//a[contains(@href,'testRepoA0XV32')]")
    private WebElement firstRepo;
    @FindBy(xpath = "//ul[contains(@class,'mini-repo-list')]//a[contains(@href,'testRepoK9TCP5')]")
    private WebElement secondRepo;
    @FindBy(xpath = "//ul[contains(@class,'mini-repo-list')]//a[contains(@href,'testRepoG9QU65')]")
    private WebElement thirdRepo;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCreateNewRepositoryButton() {
        buttonCreateNew.click();
        linkNewRepository.click();
    }

    public void clickHelp() {
        helpLink.click();
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public WebElement getButtonCreateNew() {
        return buttonCreateNew;
    }

    public WebElement getLinkNewRepository() {
        return linkNewRepository;
    }

    public WebElement getHelpLink() {
        return helpLink;
    }

    public WebElement getSearchForm() {
        return searchForm;
    }

    public WebElement getFirstRepo() {
        return firstRepo;
    }

    public WebElement getSecondRepo() {
        return secondRepo;
    }

    public WebElement getThirdRepo() {
        return thirdRepo;
    }
}

