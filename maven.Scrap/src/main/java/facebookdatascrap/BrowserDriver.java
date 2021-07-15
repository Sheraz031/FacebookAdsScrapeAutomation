package facebookdatascrap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriver {

    private WebDriverManager webDriver;
    private WebDriver driver;

    public BrowserDriver(String name, String url) {
        inilizeBrowserDriver(name, url);
    }

    public void inilizeBrowserDriver(String name, String url) {

        if (name.equalsIgnoreCase("chrome")) {
             ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
            webDriver.chromedriver().setup();
            System.out.println("Chrome is Starting");
            setDriver(new ChromeDriver(ops));
        } else if (name.equalsIgnoreCase("firefox")) {
            setDriver(new FirefoxDriver());
        } else if (name.equalsIgnoreCase("internetExplorer")) {
            setDriver(new InternetExplorerDriver());
        }
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
