package pages;

import actions.KeyWordsActionManager;
import driverManagement.WebDriverFactory;
import driverManagement.WebDriverManagerBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.util.Strings;
import utilites.EnumClass;
import utilites.Global;

public class Utilities {
   protected static KeyWordsActionManager actions;
@Step("start testing at browser ")
    public  void initialize ()
    {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        EnumClass.webBrowser browserName = EnumClass.webBrowser.valueOf( Global.getProperty("browserName"));
        // setup
        WebDriverManagerBase webDriverManagerBase= webDriverFactory.getWebDriver(browserName);
        //setup driver
        webDriverManagerBase.setupDriver();
        //get driver
        WebDriver driver= webDriverManagerBase.getDriver();
        actions = new KeyWordsActionManager(driver);
        driver.manage().deleteAllCookies();
    }
    @Step("Musala url open")

    public  void openUrl()
    {
        actions.keywordActionsElement.navigate();
        //wait page for loading
    }
    public  void refresh()
    {
        actions.keywordActionsElement.navigate();
        actions.keywordActionsElement.driver.navigate().refresh();

        //wait page for loading
    }
    public  void quit()
    {
        actions.keywordActionsElement.quit();
    }

    public void report() {
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Mill,200);
    }
}
