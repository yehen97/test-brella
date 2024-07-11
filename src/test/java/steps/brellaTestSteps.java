package steps;

import actions.getProperties;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class brellaTestSteps {

    public static WebDriver dr = null;

    @Given("I want to open the Brella Browser")
    public void iWantToOpenTheBrellaBrowser() throws IOException {

        String exePath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); //Bypass OS security model
        options.addArguments("--allowed-origins");
        options.addArguments("--disable-dev-shm-usage");

        options.addArguments("ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors=yes");
        dr = new ChromeDriver(options);

        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        dr.get(getProperties.getProperty("BaseURL"));

        dr.manage().window().maximize();
    }

}
