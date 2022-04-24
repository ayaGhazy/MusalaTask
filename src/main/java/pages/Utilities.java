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

    public  void initialize (String browser)
    {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        EnumClass.webBrowser browserName= EnumClass.webBrowser.ch;
        if (browser.equalsIgnoreCase("default")|| Strings.isNullOrEmpty(browser))
            browserName = EnumClass.webBrowser.valueOf( Global.getProperty("browserName"));
        else browserName=EnumClass.webBrowser.valueOf(browser);
        // setup
        WebDriverManagerBase webDriverManagerBase= webDriverFactory.getWebDriver(browserName);
        //setup driver
        webDriverManagerBase.setupDriver();
        //get driver
        WebDriver driver= webDriverManagerBase.getDriver();
        actions = new KeyWordsActionManager(driver);
    }
    @Step("Musala url open")

    public  void openUrl()
    {
        actions.keywordActionsElement.navigate();
        //wait page for loading
    }
    public  void close()
    {
        actions.keywordActionsElement.close();
    }
}
