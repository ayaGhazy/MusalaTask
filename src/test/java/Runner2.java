import io.qameta.allure.Description;
import org.testng.annotations.*;
import pages.Careers;
import pages.Company;
import pages.ContactUs;
import pages.Utilities;

public class Runner2 {
    Utilities utilities;
    ContactUs contactUs;
    Careers careers;

    public Runner2() {
         utilities = new Utilities();
         contactUs=new ContactUs();
         careers=new Careers();
    }

    @BeforeTest
    public void setup()
    {

        utilities.initialize();
        utilities.openUrl();
        contactUs.acceptCookies();

    }
    @BeforeMethod
    public void refresh()
    {
        utilities.openUrl();
    }

   // @Test (priority = 0,dataProvider = "email-data-provider", description="Test Case 1",retryAnalyzer = RetryAnalyzer.class)
 //   @Description("Test Description: User fill contact us form")
    public void TestCase1(String wrongEmail)
    {
        // Scroll down and go to ‘Contact Us’
        contactUs.clickContactUs();
        //fill all required fields except email
        contactUs.typeRandomTextOnName("$randomString");
        contactUs.typeInvalidTextOnEmail(wrongEmail);
        contactUs.typeRandomTextOnSubject("$randomString");
        contactUs.typeRandomTextOnMassage("$randomString");
        contactUs.clickOnSendText();
        // assert text
        contactUs.assertEmailErrorMessage();

    }
    @Test (priority = 1, description="Test Case 2",retryAnalyzer = RetryAnalyzer.class)
    @Description("Test Description: User validate company section")
    public void TestCase2()
    {
        Company company=new Company();
        company.clickCompanyBtn();
        company.assertUrl();
        company.assertOnLeadershipSection();
        company.clickOnFB();
        company.assertFbPageOpened();
        company.assertMusalaImage();

    }
    @Test (priority = 2, description="Test Case 4",retryAnalyzer = RetryAnalyzer.class)
    @Description("Test Description: Display Open Vacancies on Sofia and Skopje")
    public void TestCase4()
    {
        careers.clickCareersBtn();
        careers.clickOnOpenPositions();
        careers.displayVacanciesforCity("Sofia");
        careers.displayVacanciesforCity("Skopje");


    }
    @Test (priority = 3, description="Test Case 3",retryAnalyzer = RetryAnalyzer.class)
    @Description("Test Description: User apply job form with empty data ")
    public void TestCase3()
    {
        careers.clickCareersBtn();
        careers.clickOnOpenPositions();
        careers.assertUrl();
        careers.SelectAnyWhere();
        careers.selectJob();
        careers.verifySections();
        careers.assertandClickApplyBtn();
        contactUs.applyFor("Empty");
    }
    @Test (priority = 4,dataProvider = "data-provider", description="Test Case 3",retryAnalyzer = RetryAnalyzer.class)
    @Description("Test Description: User validate apply job form ")
    public void TestCase3_cont(String method)
    {
        //  careers.test();
        careers.navigatetoURL();
        careers.assertandClickApplyBtn();
        contactUs.applyFor(method);
    }
    @DataProvider (name = "email-data-provider")
    public Object[][] emailMethod(){
        return new Object[][] {
                {"WrongEmail"},
                {"WrongEmail2"},
                {"WrongEmail3"},
                {"WrongEmail4"},
                {"WrongEmail5"}
        };
    }
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Empty Email"},
                {"Empty Name"},
                {"Invalid Email"},
                {"Empty Mobile"},
                {"Invalid Mobile"},
                {"Empty Message"}
        };
    }
    @AfterMethod
    public void report()
    {
        utilities.report();
    }
    @AfterTest
    public void close()
    {
        utilities.quit();
    }
}
