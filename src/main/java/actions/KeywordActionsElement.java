package actions;

import csv.CSVReaderManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import utilites.Global;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class KeywordActionsElement extends KeywordActionsWait {
    Actions actions;
//set variable sheet csv

    KeywordActionsElement(WebDriver driver) {

        super(driver);
        actions = new Actions(driver);
        //
    }
    public void quit()
    {
        driver.quit();
    }


    public void close()
    {
        driver.close();
    }
    public void navigate(String url) {
        driver.navigate().to(getVariable(url));
    }
    public void navigate()
{
    driver.navigate().to(Global.getProperty("url"));
}
    public Object executeScript(String script, String text) {
        return ((JavascriptExecutor) driver).executeScript(script, fromStringToMap(text));
    }

    public void click(String element) {
        WebElement webElement =findElement(element);
       
        webElement.click();
    }
    public  void switchtoNewWindow()
    {
        //Get the current window handle
        String windowHandle = driver.getWindowHandle();

//Get the list of window handles
        ArrayList <String> tabs = new ArrayList (driver.getWindowHandles());
        System.out.println(tabs.size());
//Use the list of window handles to switch between windows
        driver.switchTo().window(tabs.get(1));
    }
    public void append(String element, String varName) {
        waitElementnotSlated(element);
        findElement(element).sendKeys(getVariable(varName));
    }
    public void appendText(String element, String text) {
        findElement(element).sendKeys(text);
    }
    public void clearText(String Element){
        findElement(Element).clear();
    }



    private Select select(String element) {
     waitElementnotSlated(element);
     waitElementToClickable(element);
        WebElement   webelement=findElement(element);
        Select select = new Select( webelement);
return select;
    }
    public void selectByIndex(String element,int index)
    {
        select(element).selectByIndex(index);
    }
    public void selectByValue(String element,String value)
    {
        select(element).selectByValue(getVariable(value));
    }
    public void selectByVisibleText(String element,String value)
    {
        select(element).selectByVisibleText(getVariable(value));
    }
    public void type(String Element, String value) {

        WebElement TargetedElement = findElement(Element);
        TargetedElement.click();
        TargetedElement.clear();
        TargetedElement.sendKeys(getVariable(value));
    }
    public void clickjs(String element) {
        WebElement webElement = findElement(element);
        actions.moveByOffset(webElement.getRect().getWidth(), webElement.getRect().getHeight()).click().build().perform();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
    }
public void clickAt(String element)
{
    WebElement webElement = findElement(element);
    KeywordActionsGet actionsGet= new KeywordActionsGet(driver);
    int [] location= actionsGet.getLocationArray(element);
    actions.moveToElement(webElement,location[0],location[1]).click(webElement).build().perform();
}
    public void scrollToElement(String po) {
        WebElement webElement = findElement(po);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        actions.moveToElement(webElement).perform();


    }
    public void scrolltoTop()
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");

    }
    public void scrollToBottom(String po) {
        WebElement webElement = findElement(po);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", webElement);
        actions.moveToElement(webElement).perform();


    }

public void switchtoFrame(WebElement element)
{
    driver.switchTo().frame(element);
}
public void switchtoDefaultContent()
{
    driver.switchTo().defaultContent();

}
}