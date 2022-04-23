import org.testng.annotations.*;
import pages.Careers;
import pages.Company;
import pages.ContactUs;
import pages.Utilites;

public class Runner {
    Utilites utilites;
    ContactUs contactUs=new ContactUs();
    Careers careers=new Careers();

    @BeforeSuite
public static void setup()
    {

        Utilites.initialize();
    }
    @BeforeMethod
    public void openUrl()
    {
        utilites=new Utilites();
        utilites.openUrl();
    }
    @Test
    public void TestCase1()
    {
        // Scroll down and go to ‘Contact Us’
        contactUs.clickContactUs();
        //fill all required fields except email
        //
        contactUs.typeRandomTextOnName("$randomString");
        contactUs.typeInvalidTextOnEmail("Email");
        contactUs.typeRandomTextOnSubject("$randomString");
        contactUs.typeRandomTextOnMassage("$randomString");
        contactUs.clickOnSendText();
        // assert text
        contactUs.assertEmailErrorMessage();

    }
    @Test
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
    @Test (dataProvider = "data-provider")
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

    @Test
    public void TestCase4()
    {
        careers.clickCareersBtn();
        careers.clickOnOpenPositions();
        careers.displayVacanciesforCity("Sofia");
        careers.displayVacanciesforCity("Skopje");


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
    //utilites.close();
}
}
