package steps;

import actions.getProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class brellaTestSteps {

    public static WebDriver dr = null;

    //ids and xpath related
    private final By txtName =By.id("form name_name");
    private final By txtEmail =By.id("form name_email");
    private final By txtNum =By.id("form name_inputNumber");
    private final By Year =By.id("form name_year");
    private final By btnSave =By.id("submit");
    private final By btnSwitch =By.id("form name_switch");
    private final By alertMsg =By.xpath("//div[@class='ant-message']//span");
    private final By testYear =By.xpath("//div[normalize-space()='2024']");


    //initialization of browser
    @Given("I want to open the Brella Browser")
    public void iWantToOpenTheBrellaBrowser() throws IOException {

        String exePath = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        dr = new ChromeDriver();

        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        dr.get(getProperties.getProperty("BaseURL"));

        dr.manage().window().maximize();
    }
    //closed the browser every testcase
    @After
    public void driverQuit(){
        dr.quit();
    }

    @And("I want to enter name as {string}")
    public void iWantToEnterNameAs(String name) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(txtName).sendKeys(name);
    }

    @And("I want to enter Email as {string}")
    public void iWantToEnterEmailAs(String email) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(txtEmail).sendKeys(email);
    }

    @And("I want to enter Input Number as {string}")
    public void iWantToEnterInputNumberAs(String number) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(txtNum).sendKeys(number);
    }

    @And("I want to select Year as {string}")
    public void iWantToSelectYearAs(String year) throws InterruptedException {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement dropdownToggle = dr.findElement(Year);
        dropdownToggle.click();

        Thread.sleep(3000);

        // Locate the option you want to select
        WebElement yearOption = dr.findElement(By.xpath("//div[normalize-space()='"+ year +"']"));

        // Use Actions to click the desired option
        Actions actions = new Actions(dr);
        actions.moveToElement(yearOption).click().perform();

    }

    @And("I want to click on save button")
    public void iWantToClickOnSaveButton() {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(btnSave).click();
    }



    @Then("I want check on error alert")
    public void iWantCheckOnErrorAlert() {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(alertMsg).isDisplayed();
        String txt = dr.findElement(alertMsg).getText();
        System.out.println(txt);

    }

    @Then("I want check on confimration alert as {string}")
    public void iWantCheckOnConfimrationAlertAs(String alert) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(alertMsg).isDisplayed();
        String txt = dr.findElement(alertMsg).getText();
        System.out.println(txt);
        Assert.assertEquals(txt,alert);
    }

    @Then("I want check on error alert as {string}")
    public void iWantCheckOnErrorAlertAs(String alert) {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(alertMsg).isDisplayed();
        String txt = dr.findElement(alertMsg).getText();
        Assert.assertEquals(txt,alert);
    }


    @And("I want to turn on status")
    public void iWantToTurnOnStatus() {
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        dr.findElement(btnSwitch).click();

    }
}
