package actions;

import actions.KeywordActionsGet;

import org.openqa.selenium.WebDriver;

import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AssertActions extends KeywordActionsGet {
WebDriver driver;
    public AssertActions(WebDriver driver) {
        super( driver);
        this.driver=driver;
    }

    Assertion assertion(boolean flag) {
        if (flag)
            return new Assertion();
        else return new SoftAssert();
    }

    public void assertText(String element, String expected, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        // expected variable should be located at variables.xslx sheet
        // actual will be located at class KeywordActionsGet
        String actual = getText(element);
        assertion(flag).assertEquals(actual, getVariable(expected), "Expected text:" + getVariable(expected) + " is not equal actual:" + actual);
    }
    public void assertUrl( String expected, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        // expected variable should be located at variables.xslx sheet
        // actual will be located at class KeywordActionsGet
        String actual = getUrl();
        assertion(flag).assertEquals(actual, getVariable(expected), "Expected text:" + getVariable(expected) + " is not equal actual:" + actual);
    }

    public void assertSelectedOption(String element, String expected, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        // expected variable should be located at variables.xslx sheet
        // actual will be located at class KeywordActionsGet
        String actual = getSelectedOption(element);
        assertion(flag).assertEquals(actual, getVariable(expected), "Expected text:" + getVariable(expected) + " is not equal actual:" + actual);
    }

    public void assertExist(String element, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        // expected variable should be located at variables.xslx sheet
        //Boolean expected =Boolean.parseBoolean(getVariableValue(variableName));
        // actual will be located at class KeywordActionsGet
        //Boolean actual = getExist(element);
        assertion(flag).assertTrue(getExist(element));
    }


    public void assertEnabled(String element, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        // expected variable should be located at variables.xslx sheet
        //String expectedString = getVariableValue(variableName);
        //Boolean expected = Boolean.parseBoolean(expectedString);
        // actual will be located at class KeywordActionsGet
        //Boolean actual = isEnabled(element);
        assertion(flag).assertTrue(isEnabled(element));
    }

    public void assertDisabled(String element, boolean flag) {
        assertion(flag).assertFalse(isEnabled(element));
    }

    public void assertChecked(String element, boolean flag) {

        assertion(flag).assertTrue(Boolean.parseBoolean(getAttribute(element, "checked")));
    }

    public void assertUnChecked(String element, boolean flag) {
        assertion(flag).assertFalse(Boolean.parseBoolean(getAttribute(element, "checked")));
    }


    /*
     * @Params Target Element to be found and VariableName
     * @Desc this function assert if a substring is included in a given string using .contains() which return a Boolean
     * @Desc the substring(VariableName) is fetched from variable sheet using getVariableValue()
     * @Desc asserts Boolean EX:(true, true)
     * */
    public void assertContains(String Element, String Contains, boolean Flag) {
        String Actual = getText(Element);
        assertion(Flag).assertEquals(Actual.contains(Contains), true, "This Substring" + Contains + "is not included in the String" + Actual);
    }

    public void assertDisplayed(String element, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        // expected variable should be located at variables.xslx sheet
        //String expectedString =getVariableValue(variableName);
        //Boolean expected =Boolean.parseBoolean(expectedString);
        // actual will be located at class KeywordActionsGet
        //Boolean actual = isDisplayed(element);
        assertion(flag).assertTrue(isDisplayed(element));
        //assertion(flag).assertEquals(actual,expected ,"Expected text:"+expected+" is not equal actual:"+actual);
    }



    public void assertAttribute(String element, String attribute, String expected, boolean flag) {
        String actual = getAttribute(element, attribute);
        assertion(flag).assertEquals(actual, getVariable(expected), "This attribute " + attribute + " is not found");
    }




}

