package pages;

import io.qameta.allure.Step;
import utilites.EnumClass;

public class Company extends Utilities {
    @Step("User click company button")

    public void clickCompanyBtn()
    {
        actions.keywordActionsElement.scrollToElement("CompanyBtn");
        actions.keywordActionsWait.waitElementExistence("CompanyBtn");
        actions.keywordActionsElement.clickUsingJS("CompanyBtn");
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Sec,5);
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
