package Packets;

import SampleFunction.SampleFunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static ConstantValue.TicketConstantValues.*;

public class FlightInfoPage extends SampleFunctionPage  {

    public FlightInfoPage(WebDriver driver) {

        super(driver);
    }
    public WebElement CheckedRoute()  {

        clickElement(By.cssSelector("#lb-way > span"));
        return findElement(By.id("lb-way"));
    }
    public FlightInfoPage FlightInfo(String flight_from , String flight_to) {

        clickElement(By.cssSelector("#lb-way > span"));
        sendKeysValue(PLANE_TAKEOFF,flight_from);
        KeyBoardClick(PLANE_TAKEOFF);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendKeysValue(PLANE_ARRIVAL,flight_to);
        KeyBoardClick(PLANE_ARRIVAL);
        return new FlightInfoPage(getDriver());
    }
    public FlightInfoPage FlightDateInfo()
    {
        clickElement(PLANE_DEPARTURE_DATE);
        clickElement(By.cssSelector(".ui-datepicker-next"));
        clickElement(By.cssSelector("tr:nth-child(3) > td:nth-child(6) > a"));
        clickElement(PLANE_RETURN_DATE);
        clickElement(By.cssSelector(".ui-datepicker-group-last"));
        clickElement(By.id("btnSearch"));
        return new FlightInfoPage(getDriver());


    }

}
