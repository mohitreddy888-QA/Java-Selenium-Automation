package SwagLabsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class SwagLabsproducts {
    private WebDriver driver;
    private WebDriverWait wait;


    public SwagLabsproducts(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    By AddSause_Labs_Backpack = By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]");
    By AddSauce_Labs_Bike_Light = By.xpath("//div[@class=inventory_list]//div[3]//div[3]//button[1]");
    By GotoCart = By.name("//*[name()='path' and contains(@fill,'currentCol')]");
    //*[name()='path' and contains(@fill,'currentCol')]
//a[normalize-space()='CHECKOUT']
    By CheckoutbuttonLocator = By.xpath("//a[normalize-space()='CHECKOUT']");
//input[@id='first-name']
    By FirstnameLocator = By.xpath("//input[@id='first-name']");
//input[@id='last-name']+
    By LastnameLocator = By.xpath("//input[@id='last-name']");
//input[@id='postal-code']
    By PostalCodeLocator = By.xpath("//input[@id='postal-code']");
//input[@value='CONTINUE']
    By ClickContinueButton = By.xpath("//input[@value='CONTINUE']");
//div[@class='summary_subtotal_label']
    By SummarySubTotalLocator = By.xpath("//div[@class='summary_subtotal_label']");
//div[@class='summary_tax_label']
    By SummaryTaxLabelLocator = By.xpath("//div[@class='summary_tax_label']");
//div[@class='summary_total_label']
    By SummaryTotalLabelLocator = By.xpath("//div[@class='summary_total_label']");
//a[normalize-space()='FINISH']
    By FinishBtnLocator = By.xpath("//a[normalize-space()='FINISH']");
//div[@class='complete-text']
    By FinalMsgTextLocator = By.xpath("//div[@class='complete-text']");

    By item_pricesLocator = By.className("inventory_item_price");

    public void SelectItems() {
        driver.findElement(AddSause_Labs_Backpack).click();
        driver.findElement(AddSauce_Labs_Bike_Light).click();
        driver.findElement(GotoCart).click();
        driver.findElement(CheckoutbuttonLocator).click();
    }

    public void CheckoutPageuserdata(String Firstname, String Lastname, String postalCode){
        driver.findElement(FirstnameLocator).sendKeys(Firstname);
        driver.findElement(LastnameLocator).sendKeys(Lastname);
        driver.findElement(PostalCodeLocator).sendKeys(postalCode);
        driver.findElement(ClickContinueButton).click();
    }



    public double getCalculatedsum(){
        List<WebElement> ItemsList =  driver.findElements(item_pricesLocator);
        double sum =0.0;
        for(WebElement price : ItemsList){
            sum+=Double.parseDouble(price.getText().replace("$",""));
        }
        return sum;
    }
    public double SubTotal(){
        return Double.parseDouble(driver.findElement(SummarySubTotalLocator).getText().replace("Item total: $",""));
    }

    public double TaxTotal(){
        return Double.parseDouble(driver.findElement(SummaryTaxLabelLocator).getText().replace("Tax: $",""));
    }

    public double Total(){
        return Double.parseDouble(driver.findElement(SummaryTotalLabelLocator).getText().replace("Total: $",""));
    }

    public void ClickFinishbtn(){
        driver.findElement(FinishBtnLocator).click();
    }

    public void Finalpage(){
        String Actual_Text = driver.findElement(FinalMsgTextLocator).getText();
        Assert.assertEquals(Actual_Text,"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
//edited in github
