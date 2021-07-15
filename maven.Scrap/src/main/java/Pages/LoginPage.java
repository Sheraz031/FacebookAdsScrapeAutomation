package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "email")
    @CacheLookup
    WebElement username;

    @FindBy(how = How.ID, using = "pass")
    @CacheLookup
    WebElement password;

    @FindBy(how = How.TAG_NAME, using = "button")
    @CacheLookup
    WebElement login;

    public void pressLogin(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.login.click();
    }
}
