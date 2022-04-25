package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import utilites.EnumClass;

import java.util.List;

public class Careers extends Utilities {
    @Step("User click on careers button")

    public void clickCareersBtn()
    {
        actions.keywordActionsElement.scrolltoTop();
        actions.keywordActionsWait.waitElementToDisplay("CareersBtn");
        try {
            actions.keywordActionsElement.click("CareersBtn");
        } catch (ElementNotInteractableException e)
            {
                actions.keywordActionsElement.navigate("CareerUrl");
            }
    }
    @Step("User click on open positions button")

    public void clickOnOpenPositions()
    {
        actions.keywordActionsWait.waitPageToLoad();
        actions.keywordActionsWait.waitElementToClickable("OpenPositions");
        actions.keywordActionsElement.click("OpenPositions");
    }
    @Step("User assert page url")

    public void assertUrl()
    {
        actions.assertActions.assertUrl("JoinUsUrl",false);
    }
    @Step("User select anywhere from drop down")

    public void SelectAnyWhere()
    {
        actions.keywordActionsElement.selectByValue("selectAnyWhere","SelectAnyWhere");

    }
    @Step("User display all vacancies  based on city {0} ")

    public void displayVacanciesforCity(String city)
    {
        actions.keywordActionsWait.waitElementExistence("selectAnyWhere");
        actions.keywordActionsElement.selectByValue("selectAnyWhere",city);
        System.out.println(city);
        Allure.addAttachment("Console log: ",city);
                displayVacancies();

    }
    public void displayVacancies()
    {
      List<WebElement> elementList= actions.keywordActionsElement.findElements("cards1");
        for (WebElement el:elementList
             ) {
            System.out.println(  "Position: "+  actions.keywordActionsGet.getText(el).split("\n")[0]);
            Allure.addAttachment("Console log: ", "Position: "+  actions.keywordActionsGet.getText(el).split("\n")[0]);

            System.out.println(  "More info: "+  actions.keywordActionsGet.getAttribute(el,"href"));
            Allure.addAttachment("Console log: ",  "More info: "+  actions.keywordActionsGet.getAttribute(el,"href"));

        }

    }
    @Step("User select Test automation job")

    public void selectJob()
    {
        actions.keywordActionsWait.waitElementnotSlated("ChooseJob");
        actions.keywordActionsWait.waitElementToClickable("ChooseJob");
        actions.keywordActionsElement.click("ChooseJob");

    }
    @Step("User can verify sections displayed")

    public void verifySections()
    {
        actions.assertActions.assertText("GeneralDescription","GeneralDescription",false);
        actions.assertActions.assertText("Requirements","Requirements",false);
        actions.assertActions.assertText("Responsibilities","Responsibilities",false);
        actions.assertActions.assertText("WhatWeOffer","WhatWeOffer",false);

    }
    @Step("User assert and click apply button")

    public void assertandClickApplyBtn()
    {
        actions.keywordActionsElement.scrollToElement("applyBtn");
        actions.assertActions.assertDisplayed("applyBtn",false);
        actions.keywordActionsElement.click("applyBtn");
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Sec,3);
    }

    public void navigatetoURL() {
        actions.keywordActionsElement.navigate("JobUrl");
    }
}
