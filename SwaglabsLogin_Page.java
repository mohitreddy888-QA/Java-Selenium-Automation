package SwagLabsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SwaglabsLogin_Page {

    private WebDriver driver;
    private WebDriverWait wait;
    public SwaglabsLogin_Page(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By SubmitButtonlocator = By.id("login-button");
    By ErrorMessage = By.xpath("//h3[@data-test='error']");
    String Expected_ErrorMessage = "Epic sadface: Username and password do not match any user in this service";


    public void provideUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }
    public void providePassword (String Password){
        driver.findElement(passwordLocator).sendKeys(Password);
    }
    public void ClickSubmitBtn(){
        driver.findElement(SubmitButtonlocator).click();
    }

    public void ErrorValidation(){
        String Actual_ErrorMessage =wait.until(ExpectedConditions.visibilityOf(driver.findElement(ErrorMessage))).getText();
        Assert.assertEquals(Actual_ErrorMessage,Expected_ErrorMessage);
    }

}





