package Pages;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addsPage {

    ArrayList<String> urlsList = new ArrayList<String>();
    ArrayList<WebDriver> driverList = new ArrayList<WebDriver>();

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/div/div[1]")
    @CacheLookup
    WebElement selectAll;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div[1]/div[2]/div[4]/div/div[2]/div[1]/div/div/div/div[1]/div/div/div[1]/input")
    @CacheLookup
    WebElement allCountry;

    WebDriver driver;

    public addsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> Adds() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
        }

        int m = 0;
        selectAll.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
        }
        allCountry.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        List<WebElement> element = driver.findElements(By.xpath("//div[@role='heading']"));
        for (int i = 0; i < element.size(); i++) {
           
             List<WebElement> element22 = driver.findElements(By.xpath("//div[@role='heading']")); 
               WebElement ele = element22.get(i);
            if (ele.getText().equalsIgnoreCase("See Ad Details")) {
                ele.click();
                 new addsDetails(driver).printDetial();           

            }
        }

        return allLinks;
    }

    public String getUrl() {
        int ite = 0;
        String url = "";
        WebDriver mydriver = driver;
        Set<String> handles = mydriver.getWindowHandles();
        for (String handle : handles) {
            ite++;
            if (ite == handles.size()) {
                mydriver.switchTo().window(handle);
                url = mydriver.getCurrentUrl();
            }
        }
        return url;
    }
}
