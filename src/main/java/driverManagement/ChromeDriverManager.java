package driverManagement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager extends WebDriverManagerBase {


    @Override
    public WebDriver getDriver()  {
            driver=new ChromeDriver();
        return driver;
    }
    @Override
    public void setupDriver()
    {
        WebDriverManager.chromedriver().setup();
    }


}
