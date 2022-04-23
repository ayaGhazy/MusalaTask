package pages;

import utilites.EnumClass;
import utilites.Global;

public class ContactUs extends Utilites{
    public void clickContactUs()
    {
        actions.keywordActionsElement.scrollToElement("ContactUsBtn");
        actions.keywordActionsElement.click("ContactUsBtn");
    }
    public void typeRandomTextOnName(String text)
    {
        actions.keywordActionsElement.type("NameTxt",text);

    }

    public void typeInvalidTextOnEmail(String text)
    {
        actions.keywordActionsElement.type("EmailTxt",text);

    }
    public void typeInvalidTextOnMobile(String text)
    {
        actions.keywordActionsElement.type("MobileTxt",text);

    }
    public void typeRandomTextOnSubject(String text)
    {
        actions.keywordActionsElement.type("SubjectTxt",text);

    }
    public void uploadCV(String text)
    {
        actions.keywordActionsElement.append("UploadTxt",text);

    }
    public void typeRandomTextOnMassage(String  text)
    {
        actions.keywordActionsElement.type("MessageTxt", text);

    }
    public void clickOnSendText()
    {
        actions.keywordActionsElement.click("SendBtn");

    }
    public void assertEmailErrorMessage()
    {
        actions.keywordActionsWait.waitElementExistence("EmailErrorMessage");
        actions.assertActions.assertText("EmailErrorMessage","EmailError",true);
    }
    public void assertError(String elementName , String error)
    {
        actions.keywordActionsWait.waitElementExistence(elementName);
        actions.assertActions.assertText(elementName,error,true);
    }
    public void clickAcceptButton()
    {
        actions.keywordActionsElement.click("checkBoxBtn");
    }
    public void sendButton()
    {
        actions.keywordActionsElement.click("SendBtn");
    }
    public void closeButton()
    {
        actions.keywordActionsElement.clickUsingJS("CloseBtn");
    }
    public void continueApply()
    {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        uploadCV(System.getProperty("user.dir")+"/"+Global.getProperty("attachmentURL"));
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Sec,10);

        clickAcceptButton();
        sendButton();
        actions.keywordActionsWait.sleep(EnumClass.sleepMode.Mill,200);
        closeButton();
    }
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
