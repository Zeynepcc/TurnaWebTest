package Packets;

import SampleFunction.SampleFunctionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ConstantValue.InfoConstantValues.*;
import static ConstantValue.TicketConstantValues.*;

public class PersonInfoPage extends SampleFunctionPage {

    public PersonInfoPage(WebDriver driver) {
        super(driver);
    }
    public boolean FlyInfoControl()
    {
       if(findElement(PLANE_TAKEOFF).getAttribute("value").equals("")
               || findElement(PLANE_ARRIVAL).getAttribute("value").equals("")
       || findElement(PLANE_DEPARTURE_DATE).getAttribute("value").equals("")
       || findElement(PLANE_RETURN_DATE).getAttribute("value").equals(""))
       {
           return  false;
       }
       else
       {
           return  true;
       }
    }
    public PersonInfoPage ChoosePlanesSettings()
    {
        //clickElement(By.cssSelector("#\\31 002 > .amount-wrapper > div.button > input"));
        //Her yolu denedim ama sadece xpath absolute yolunu kabul ediyor.
        clickElement(By.id("1002"));
        clickElement(By.xpath("//*[@id=\"1002\"]/div[2]/div[2]"));
        clickElement(By.id("1104"));
        clickElement(By.xpath("//*[@id=\"1104\"]/div[2]/div[2]"));
        return new PersonInfoPage((getDriver()));
    }
    public boolean isSelectedPlanes()
    {
        ChoosePlanesSettings();
        String air_from =getAttribute(By.cssSelector
                ("input.from-in-button"),"value");
        String air_to = getAttribute(By.cssSelector
                ("input.to-in-button"),"value");
        if(air_from.equals("Seçili")
                && air_to.equals("Seçili"))
            return true;
        else
            return  false;

    }
    public double isTotalTruePrice()
    {
        ChoosePlanesSettings();
       String first_price = findElement
               (By.cssSelector(".price > .money-val"))
               .getText();
       String second_price = findElement
               (By.xpath("//*[@id=\"1104\"]/div[2]/div[1]/span"))
               .getText();
       double total_price = Double.parseDouble(first_price) + Double.parseDouble(second_price);
       return total_price;

    }
    public PersonInfoPage FillInfo(String name , String surname , String identity , String hes, String national)
    {
        ChoosePlanesSettings();
        clickElement(By.cssSelector(".bt-choose"));

        sendKeysValue(NAME,name);
        sendKeysValue(SURNAME,surname);
        selectOptionByValue(By.cssSelector("div.select-box.day > select"),"07");
        selectOptionByValue(By.cssSelector("div.select-box.month > select"),"01");
        selectOptionByValue(By.cssSelector("div.select-box.year > select"),"1997");
        selectOptionByValue(NATIONALITY,national);
        sendKeysValue(IDENTITY_NO,identity);
        sendKeysValue(HES_CODE,hes);
        clickElement(GENDER);
        return new PersonInfoPage(getDriver());
    }
}

