package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.EnumClass;

import java.util.List;

public class Careers extends Utilites {
    public void clickCareersBtn()
    {
        actions.keywordActionsElement.scrollToElement("CareersBtn");
        actions.keywordActionsElement.click("CareersBtn");
    }
    public void clickOnOpenPositions()
    {
        actions.keywordActionsWait.waitPageToLoad();
        actions.keywordActionsElement.click("AcceptBtn");
        actions.keywordActionsElement.click("OpenPositions");
    }
    public void assertUrl()
    {
        actions.assertActions.assertUrl("JoinUsUrl",false);
    }
    public void SelectAnyWhere()
    {
        actions.keywordActionsElement.selectByValue("selectAnyWhere","SelectAnyWhere");

    }
    public void displayVacanciesforCity(String city)
    {
        actions.keywordActionsElement.selectByValue("selectAnyWhere",city);
        System.out.println(city);
        displayVacancies();

    }
    public void displayVacancies()
    {
      List<WebElement> elementList= actions.keywordActionsElement.findElements("cards1");
        for (WebElement el:elementList
             ) {
            System.out.println(  "Position: "+  actions.keywordActionsGet.getText(el).split("\n")[0]);
            System.out.println(  "More info: "+  actions.keywordActionsGet.getAttribute(el,"href"));

        }

    }
    public void selectJob()
    {
        actions.keywordActionsElement.click("ChooseJob");

    }
    public void verifySections()
    {
        actions.assertActions.assertText("GeneralDescription","GeneralDescription",false);
        actions.assertActions.assertText("Requirements","Requirements",false);
        actions.assertActions.assertText("Responsibilities","Responsibilities",false);
        actions.assertActions.assertText("WhatWeOffer","WhatWeOffer",false);

    }
    public void assertandClickApplyBtn()
    {
        actions.keywordActionsElement.scrollToElement("applyBtn");
        actions.assertActions.assertDisplayed("applyBtn",false);
        actions.keywordActionsElement.click("applyBtn");
    }
    public void test()
    {
        actions.keywordActionsElement.driver.navigate().to("https://www.musala.com/job/experienced-automation-qa-engineer/");

    }
}
