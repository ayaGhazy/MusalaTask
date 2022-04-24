import io.qameta.allure.Description;
import org.testng.annotations.*;
import pages.Careers;
import pages.Company;
import pages.ContactUs;
import pages.Utilities;

public class Runner {
    Utilities utilities = new Utilities();
    ContactUs contactUs=new ContactUs();
    Careers careers=new Careers();

    @BeforeTest
    @Parameters({"browser"})
public void setup(@Optional ("default") String browser)
    {

        utilities.initialize(browser);
        utilities.openUrl();
        contactUs.acceptCookies();

    }
@BeforeMethod
public void openUrl()
{
    utilities.openUrl();
}

    @Test (priority = 0, description="Test Case 1")
    @Description("Test Description: User fill contact us form")
    public void TestCase1()
    {
                // Scroll down and go to ‘Contact Us’
        contactUs.clickContactUs();
        //fill all required fields except email
        contactUs.typeRandomTextOnName("$randomString");
        contactUs.typeInvalidTextOnEmail("WrongEmail");
        contactUs.typeRandomTextOnSubject("$randomString");
        contactUs.typeRandomTextOnMassage("$randomString");
        contactUs.clickOnSendText();
        // assert text
        contactUs.assertEmailErrorMessage();

    }
    @Test (priority = 1, description="Test Case 2")
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
    @Test (priority = 2, description="Test Case 4")
    @Description("Test Description: Display Open Vacancies on Sofia and Skopje")
    public void TestCase4()
    {
        careers.clickCareersBtn();
        careers.clickOnOpenPositions();
        careers.displayVacanciesforCity("Sofia");
        careers.displayVacanciesforCity("Skopje");


    }
    @Test (priority = 3,dataProvider = "data-provider", description="Test Case 3")
    @Description("Test Description: User validate apply job form ")
    public void TestCase3(String method)
    {
        careers.clickCareersBtn();
        careers.clickOnOpenPositions();
        careers.assertUrl();
        careers.SelectAnyWhere();
        careers.selectJob();
        careers.verifySections();
      //  careers.test();
        careers.assertandClickApplyBtn();
        contactUs.applyFor(method);
    }


        @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"Empty Email"},
                {"Empty Name"},
                {"Invalid Email"},
                {"Empty Mobile"},
                {"Invalid Mobile"},
                {"Empty Message"},
                {"Empty"},
        };
    }
@AfterTest
    public void close()
{
    utilities.close();
}
}
