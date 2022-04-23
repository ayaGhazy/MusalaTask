package pages;

import actions.KeyWordsActionManager;
import driverManagement.WebDriverFactory;
import driverManagement.WebDriverManagerBase;
import org.openqa.selenium.WebDriver;
import utilites.EnumClass;
import utilites.Global;

public class Utilites {
   protected static KeyWordsActionManager actions;

    public static void initialize ()
    {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        EnumClass.webBrowser browserName= EnumClass.webBrowser.valueOf( Global.getProperty("browserName"));
        // setup
        WebDriverManagerBase webDriverManagerBase= webDriverFactory.getWebDriver(browserName);
        //setup driver
        webDriverManagerBase.setupDriver();
        //get driver
        WebDriver driver= webDriverManagerBase.getDriver();
        actions = new KeyWordsActionManager(driver);
    }
    public  void openUrl()
    {
        actions.keywordActionsElement.navigate();
        //wait page for loading
    }
    public void close()
    {
        actions.keywordActionsElement.close();
    }
}
