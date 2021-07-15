package facebookdatascrap;

import Pages.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

public class FaceBookDataScrape {

    public static void main(String[] args) {
        WebDriver driver = null;
        boolean flag = true;
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        try {
            System.out.println("\n\nEnter the Username");
            Scanner sc = new Scanner(System.in);
            String username = sc.nextLine();

            System.out.println("Enter the Password");
            String password = sc.nextLine();
            driver = new BrowserDriver("chrome", "https://www.facebook.com/").getDriver();
            LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

            loginpage.pressLogin(username, password);
            //  below code will open Tab for you as well as switch the control to new Tab
            driver.switchTo().newWindow(WindowType.TAB);
            flag = false;
            sc.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid User Name Or Password: \n    Try Again");
            driver.close();
            flag = true;

        }
        WebDriver drivertemp=driver;
flag=true;
while(flag)
         try {
        String url = JOptionPane.showInputDialog(frame, "Paste The Url if you don't want to proceed Just left Empty \n and click ok Thanks!!");
        if (url.isEmpty() || url == null) {
            flag = false;
        }
        if (flag) {
        	driver=drivertemp;
            // below code will navigate you to your desirable Url 
            driver.get(url);
            pageTranprancy trancpancyPage = PageFactory.initElements(driver, pageTranprancy.class);
            String addsPageUrl = trancpancyPage.seeAll();

            driver.get(addsPageUrl);
            addsPage addpage = PageFactory.initElements(driver, addsPage.class);
            List<WebElement> driverlist = addpage.Adds();

            if (driverlist.size() < 1) {
                JOptionPane.showMessageDialog(frame, "This User Don't Have Adds \n    Try Another");
            } else {
                System.out.println("Number of Add" + driverlist.size());
            }

            for (int i = 1; i < driverlist.size(); i++) {
                System.out.println(driverlist.get(i).getText()+"     "+driverlist.get(i).getAttribute("href"));
                //new addsDetails(driverlist.get(i)).printDetial();
            }
        }
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "You Never LoggedIn, Invalid Url \nOr Adds Already Downloaded!!\n      Try Another Url");
               // System.out.println(e.getMessage());
                flag = true;
                driver.close();
            }

    }

}
