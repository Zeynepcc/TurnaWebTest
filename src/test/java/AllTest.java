import BaseConfig.BaseConfigPage;
import Packets.FlightInfoPage;
import Packets.PersonInfoPage;
import Packets.TicketHome;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AllTest extends BaseConfigPage {

    @Test
    public void CheckedTest() {

           WebElement is_selected = (WebElement) new TicketHome(getDriver())
                   .callInfoPage()
                   .CheckedRoute();
            Assert.assertEquals(is_selected.getAttribute("class"),"active");
    }
    @Test
    public void FlightInfoTest() throws InterruptedException {

        new TicketHome(getDriver())
                .callInfoPage()
                .FlightInfo("İstanbul","Esenboğa");
    }
    @Test
    public void FlightDateInfoTest()
    {
        new TicketHome(getDriver())
                .callInfoPage()
                .FlightInfo("İstanbul","Esenboğa")
                .callInfoPage().FlightDateInfo();
    }
    @Test
    public  void PersonInfoControlTest()
    {
       boolean istrue =  new TicketHome(getDriver())
                .callInfoPage()
                .FlightInfo("İstanbul","Esenboğa")
                .callInfoPage().FlightDateInfo().callPersonInfoPage().FlyInfoControl();
       Assert.assertTrue(istrue);
    }
    @Test
    public void ChoosePlanesTest()
    {
       Boolean istrue =  new TicketHome(getDriver())
                .callInfoPage()
                .FlightInfo("İstanbul","Esenboğa")
                .callInfoPage().FlightDateInfo()
                .callPersonInfoPage().isSelectedPlanes();
        Assert.assertTrue(istrue);

    }
    @Test
    public void IsTrueTotalPriceTest()
    {
       double total_price = new TicketHome(getDriver())
                .callInfoPage()
                .FlightInfo("İstanbul","Esenboğa")
                .callInfoPage().FlightDateInfo()
                .callPersonInfoPage().isTotalTruePrice();
       String main_total_price = getDriver()
               .findElement(By.cssSelector("#total-price > .price")).getText();
        Assert.assertEquals(main_total_price.substring(0,main_total_price.length() -4), String.valueOf(total_price));

    }
    @Test
    public void FillInfo()
    {
        new TicketHome(getDriver())
                .callInfoPage()
                .FlightInfo("İstanbul","Esenboğa")
                .callInfoPage().FlightDateInfo()
                .callPersonInfoPage().FillInfo("Zeynep","Turhan","2222222222","4332535345","TR");
    }

}