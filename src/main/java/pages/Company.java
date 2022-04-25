package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import utilites.EnumClass;

import java.util.List;

public class Company extends Utilities {
    @Step("User click company button")

    public void clickCompanyBtn()
    {
        actions.keywordActionsElement.scrollToElement("CompanyBtn");
        try {
            actions.keywordActionsElement.click("CompanyBtn");
        }
        catch (ElementNotInteractableException e)
        {
           actions.keywordActionsElement.navigate("CompanyUrl");
        }
    }
    @Step("User assert company page url")

    public void assertUrl()
    {
        actions.assertActions.assertUrl("CompanyUrl",false);
    }
    @Step("User validate on leadership section")

    public void assertOnLeadershipSection()
    {
        actions.assertActions.assertText("LeadershipH2","sectionText",true);
    }
    @Step("User click on facebook button")

    public void clickOnFB()
    {
actions.keywordActionsWait.waitPageToLoad();
   actions.keywordActionsElement.click("FbPage");
   actions.keywordActionsElement.switchtoNewWindow();
    }
    @Step("User assert facebook page opened")

    public void assertFbPageOpened()
    {
        actions.keywordActionsWait.waitPageToLoad();
        actions.assertActions.assertUrl("fbUrl",true);
    }
    @Step("User assert musala image exists on facebook page")

    public void assertMusalaImage()
    {
        actions.keywordActionsWait.waitPageToLoad();
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Mill,500);
        actions.assertActions.assertDisplayed("image",true);
        actions.keywordActionsElement.switchtoDefaultContent();
    }
}
