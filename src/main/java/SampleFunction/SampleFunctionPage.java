package SampleFunction;

import Packets.FlightInfoPage;
import Packets.PersonInfoPage;
import Packets.TicketHome;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SampleFunctionPage {


    private WebDriver driver;
    WebDriverWait wait;

    public SampleFunctionPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public TicketHome callTicketPage()
    {
        clickElement(By.cssSelector("#lb-way > span"));
        return new TicketHome(getDriver());
    }
    public FlightInfoPage callInfoPage()
    {
        return new FlightInfoPage(getDriver());
    }
    public PersonInfoPage callPersonInfoPage()
    {
        return new PersonInfoPage(getDriver());
    }
    public WebElement findElement(By by)
    {
        untilElementLocated(by);
        return getDriver().findElement(by);
    }
    public void clickElement(By by) {

        untilElementClickable(by);
        getDriver().findElement(by).click();
    }
    public void sendKeysValue(By by, String text) {

        findElement(by).clear();
        findElement(by).sendKeys(text);
    }
    public void untilElementLocated(By by)
    {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void untilElementClickable(By by)
    {
        new WebDriverWait(getDriver(), 30).
                until(ExpectedConditions.elementToBeClickable(by));
    }
    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public void selectOptionByValue(By by, String value) {
        Select select = new Select(findElement(by));
        select.selectByValue(value);
    }
    public String getAttribute(By by, String name) {

        return findElement(by).getAttribute(name);
    }
    public void FindBySelector(String element)
    {
        untilElementLocated(By.cssSelector(element));
        findElement(By.cssSelector(element));

    }
    public void FindByXPath(String element)
    {
        untilElementLocated(By.xpath(element));
        findElement(By.cssSelector(element));
    }
    public List<WebElement> getElementsByXpath(String s)
    {
        untilElementLocated(By.xpath(s));
        return getDriver().findElements(By.xpath(s));
    }
    public void KeyBoardClick(By by)
    {
        untilElementLocated(by);
        findElement(by).sendKeys(Keys.ENTER);
    }

}
