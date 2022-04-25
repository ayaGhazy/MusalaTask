package pages;

import io.qameta.allure.Step;
import utilites.EnumClass;
import utilites.Global;

public class ContactUs extends Utilities {
    public  void acceptCookies()
    {
            actions.keywordActionsWait.waitElementToClickable("AcceptBtn");
            actions.keywordActionsElement.click("AcceptBtn");
    }
    @Step("User Click at Contact Us Button")
    public void clickContactUs()
    {
        actions.keywordActionsElement.scrolltoTop();
        actions.keywordActionsElement.click("ContactUsBtn");
    }
    @Step("User type {0} in Name")
    public void typeRandomTextOnName(String text)
    {
        actions.keywordActionsElement.append("NameTxt",text);

    }
    @Step("User type {0} in Email")

    public void typeInvalidTextOnEmail(String text)
    {
        actions.keywordActionsElement.append("EmailTxt",text);

    }
    @Step("User type {0} in Mobile")

    public void typeInvalidTextOnMobile(String text)
    {
        actions.keywordActionsElement.append("MobileTxt",text);

    }
    @Step("User type {0} in Subject")

    public void typeRandomTextOnSubject(String text)
    {
        actions.keywordActionsElement.append("SubjectTxt",text);

    }
    @Step("User upload cv")

    public void uploadCV(String text)
    {
        actions.keywordActionsElement.appendText("UploadTxt",text);

    }
    @Step("User type {0} in Message box")

    public void typeRandomTextOnMassage(String  text)
    {
        actions.keywordActionsElement.append("MessageTxt", text);

    }
    @Step("User click on send text")

    public void clickOnSendText()
    {
        actions.keywordActionsElement.click("SendBtn");

    }
    @Step("User assert email error Message")

    public void assertEmailErrorMessage()
    {
        actions.keywordActionsWait.waitElementExistence("EmailErrorMessage");
        actions.assertActions.assertText("EmailErrorMessage","EmailError",true);
    }
    @Step("User assert {0} error Message")

    public void assertError(String elementName , String error)
    {
        actions.keywordActionsWait.waitElementExistence(elementName);
        actions.assertActions.assertText(elementName,error,true);
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Mill,200);
    }
    @Step("User check accept checkbox")

    public void clickAcceptButton()
    {
        actions.keywordActionsElement.click("checkBoxBtn");
    }
    @Step("User click send button")

    public void sendButton()
    {
        actions.keywordActionsElement.click("SendBtn");
    }
    @Step("User click close button")

    public void closeButton()
    {
        actions.keywordActionsWait.waitElementToDisplay("CloseBtn");
        actions.keywordActionsElement.clickAt("CloseBtn");
    }
    @Step("User upload cv then click send button")

    public void continueApply()
    {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        uploadCV(System.getProperty("user.dir")+"/"+Global.getProperty("attachmentURL"));
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Sec,10);

        clickAcceptButton();
        sendButton();
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Mill,200);
        //closeButton();
    }
    @Step("User validate 'Apply for page' for {0} ")

    public void applyFor(String text)
    {
     switch (text)
     {
         case "Empty Name":
             typeRandomTextOnName("EmptyString");
             typeInvalidTextOnEmail("Email");
             typeInvalidTextOnMobile("MobileNo");
             typeRandomTextOnMassage("$randomString");
             continueApply();
             assertError("NameErrorMessage","Error");
             break;
         case "Empty Email":
             typeRandomTextOnName("$randomString");
             typeInvalidTextOnEmail("EmptyString");
             typeInvalidTextOnMobile("MobileNo");
             typeRandomTextOnMassage("$randomString");
             continueApply();
             assertError("EmailErrorMessage","Error");
             break;
         case "Invalid Email":
             typeRandomTextOnName("$randomString");
             typeInvalidTextOnEmail("$randomString");
             typeInvalidTextOnMobile("MobileNo");
             typeRandomTextOnMassage("$randomString");
             continueApply();
             assertError("EmailErrorMessage","EmailError");
             break;
         case "Empty Mobile":
             typeRandomTextOnName("$randomString");
             typeInvalidTextOnEmail("Email");
             typeInvalidTextOnMobile("EmptyString");
             typeRandomTextOnMassage("$randomString");
             continueApply();
             assertError("MobileErrorMessage","Error");
             break;
         case "Invalid Mobile":
             typeRandomTextOnName("$randomString");
             typeInvalidTextOnEmail("Email");
             typeInvalidTextOnMobile("$randomString");
             typeRandomTextOnMassage("$randomString");
             continueApply();
             assertError("MobileErrorMessage","MobileError");
             break;
         case "Empty Message":
             typeRandomTextOnName("$randomString");
             typeInvalidTextOnEmail("Email");
             typeInvalidTextOnMobile("MobileNo");
             typeRandomTextOnMassage("EmptyString");
             continueApply();
             assertError("MessageErrorMessage","Error");
             break;
         case "Empty":
             typeRandomTextOnName("EmptyString");
             typeInvalidTextOnEmail("EmptyString");
             typeInvalidTextOnMobile("EmptyString");
             typeRandomTextOnMassage("EmptyString");
             continueApply();
             assertError("NameErrorMessage","Error");
             assertError("EmailErrorMessage","Error");
             assertError("MobileErrorMessage","Error");
             assertError("MessageErrorMessage","Error");
             break;
     }

    }
}
