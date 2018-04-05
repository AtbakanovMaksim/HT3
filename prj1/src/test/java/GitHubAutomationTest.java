import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import steps.Steps;

public class GitHubAutomationTest {
    private Steps steps;
    private final String USERNAME = "testautomationuser";
    private final String PASSWORD = "Time4Death!";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

//	@Test
//	public void oneCanCreateProject()
//	{
//		steps.loginGithub(USERNAME, PASSWORD);
//		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
//		Assert.assertTrue(steps.currentRepositoryIsEmpty());
//		// do not use lots of asserts
//	}
//
//	@Test(description = "Login to Github")
//	public void oneCanLoginGithub()
//	{
//		steps.loginGithub(USERNAME, PASSWORD);
//		Assert.assertTrue(steps.isLoggedIn(USERNAME));
//	}

    @Test(description = "Check what browsers is supported")
    public void isBrowserSupported() {
        SoftAssert softAssert = new SoftAssert();
        steps.loginGithub(USERNAME, PASSWORD);
        steps.callHelpPage();
        steps.learnSupportedBrowser();
        softAssert.assertTrue(steps.isChromeSupported());
        softAssert.assertTrue(steps.isFirefoxSupported());
        softAssert.assertTrue(steps.isExplorerSupported());
        softAssert.assertTrue(steps.isMSEdgeSupported());
        softAssert.assertTrue(steps.isSafariSupported());
        softAssert.assertTrue(steps.isOperaSupported());
    }

    @Test(description = "Check form to contact support")
    public void supportFormTest() {
        steps.loginGithub(USERNAME, PASSWORD);
        steps.callHelpPage();
        steps.contackSupport();
        Assert.assertTrue(steps.isNameFormDisplayed());
        Assert.assertTrue(steps.isEmailFormDisplayed());
        Assert.assertTrue(steps.isSubjectFormDisplayed());
        Assert.assertTrue(steps.isTextFormDisplayed());
        Assert.assertTrue(steps.isAttachFormDisplayed());
        Assert.assertTrue(steps.isSubmitButtonDisplayed());
    }

    @Test(description = "Check searching in repo")
    public void searchFormTest() {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isFirstRepoLinkVisible());
        Assert.assertTrue(steps.isSecondRepoLinkVisible());
        Assert.assertTrue(steps.isThirdRepoLinkVisible());
        steps.searchFirstRepo();
        Assert.assertTrue(steps.isFirstRepoLinkVisible());
        Assert.assertFalse(steps.isSecondRepoLinkVisible());
        Assert.assertFalse(steps.isThirdRepoLinkVisible());

    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
