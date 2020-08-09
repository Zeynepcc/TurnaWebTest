package BaseConfig;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseConfigPage {


    static private WebDriver driver;
    static Properties prop;

    @Before
    public void Prepare()
    {
        ChangeBrowser();
        String browser = prop.getProperty("browser");
        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "Settings\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox"))
        {
            System.setProperty("webdriver.chrome.driver", "Settings\\ChromeDriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equals("explorer"))
        {
            //
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @After
    public void Finish()
    {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void ChangeBrowser()
    {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("Settings/ChooseDriver");
                    prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
