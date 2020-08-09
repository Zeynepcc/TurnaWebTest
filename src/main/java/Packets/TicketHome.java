package Packets;

import SampleFunction.SampleFunctionPage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.concurrent.TimeUnit;

import static ConstantValue.TicketConstantValues.*;

public class TicketHome extends SampleFunctionPage {

    public TicketHome(WebDriver driver) {

        super(driver);
        driver.get("https://www.turna.com/");
    }


}
