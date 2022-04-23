package pages;

import utilites.EnumClass;

public class Company extends Utilites {
    public void clickCompanyBtn()
    {
        actions.keywordActionsElement.scrollToElement("CompanyBtn");
        actions.keywordActionsElement.click("CompanyBtn");
    }
    public void assertUrl()
    {
        actions.assertActions.assertUrl("CompanyUrl",false);
    }
    public void assertOnLeadershipSection()
    {
        actions.assertActions.assertText("LeadershipH2","sectionText",true);
    }
    public void clickOnFB()
    {
actions.keywordActionsWait.waitPageToLoad();
   actions.keywordActionsElement.click("AcceptBtn");
   actions.keywordActionsElement.click("FbPage");
   actions.keywordActionsElement.switchtoNewWindow();
    }
    public void assertFbPageOpened()
    {
        actions.keywordActionsWait.waitPageToLoad();
        actions.assertActions.assertUrl("fbUrl",true);
    }
    public void assertMusalaImage()
    {
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Mill,300);
        actions.assertActions.assertDisplayed("image",true);
    }
}
