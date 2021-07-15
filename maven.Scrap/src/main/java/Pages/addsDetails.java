package Pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class addsDetails {

    ArrayList<String> videoSrcList = new ArrayList<String>();
    String aboutAdd;
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div/div/div/div[3]/span/div[1]/div/div[2]/div/div[1]/div/div/div[1]/div[1]/div/div/a/span")
    @CacheLookup
    WebElement name;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div/div/div/div[3]/span/div[1]/div/div[2]/div/div[1]/div/div/div[1]/div[2]/span/div/div/span[1]")
    @CacheLookup
    WebElement sponser;

    @FindBy(how = How.XPATH, using = "")
    @CacheLookup
    WebElement id;

    @FindBy(how = How.XPATH, using = "")
    @CacheLookup
    WebElement text;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/div/div/div/div[3]/span/div[1]/div/div[2]/div/div[1]/div/img")
    @CacheLookup
    WebElement imagePath;

    WebDriver driver;

    public addsDetails(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver printDetial() {
    	int number=new Random().nextInt(1000);
        String text = "//ABOUT THE ADD//\n";
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(pageTranprancy.class.getName()).log(Level.SEVERE, null, ex);
        }

        String username = driver.findElements(By.xpath("//span[@class='l61y9joe bnyswc7j ga2uhi05 te7ihjl9 svz86pwt cu1gti5y a53abz89']")).get(0).getText();

        String imageUrl = driver.findElements(By.xpath("//img[@class='_8nqq img']")).get(0).getAttribute("src");

        List<WebElement> videoList = driver.findElements(By.xpath("//video[@height='100%']"));
        for (int i = 0; i < videoList.size(); i++) {
            WebElement ele = videoList.get(i);
            if (!ele.getAttribute("src").isEmpty()) {
                if (!videoSrcList.contains(ele.getAttribute("src"))) {
                    videoSrcList.add(ele.getAttribute("src"));
                }
            }

        }

        List<WebElement> aboutAdd = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/div[3]/span/div[1]/div/div[2]/div"));
        for (int i = 0; i < aboutAdd.size(); i++) {
            WebElement ele = aboutAdd.get(i);
            if (!ele.getText().isEmpty()) {
                System.out.println(ele.getText());
                text = text + ele.getText();
            }

        }
        text=text+"\n\n\n//ABOUT THE PAGE//\n";
        System.out.println("\n\n");

        List<WebElement> aboutPage = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/div[3]/span/div[2]/div"));
        for (int i = 0; i < aboutPage.size(); i++) {
            WebElement ele = aboutPage.get(i);
            if (!ele.getText().isEmpty()) {
                System.out.println(ele.getText());
                text = text + ele.getText();
            }
        }
        System.out.println("\n\n\n//SAVING DATA INTO C DRIVER//");

        File theDir2 = new File("C:/FaceBookScrape/Data/" + username + "/Text");
        if (!theDir2.exists()) {
            theDir2.mkdirs();
        }
        new SaveData().saveText("C:/FaceBookScrape/Data/" + username + "/Text/" + number + ".txt", text);

        File theDir = new File("C:/FaceBookScrape/Data/" + username + "/Images");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        new SaveData().saveImage("C:/FaceBookScrape/Data/" + username + "/Images/" + number + ".jpg", imageUrl);

        System.out.println("videos are downloading");
        File theDir1 = new File("C:/FaceBookScrape/Data/" + username + "/Videos");
        if (!theDir1.exists()) {
            theDir1.mkdirs();
        }
        for (int i = 0; i < videoSrcList.size(); i++) {
            new SaveData().saveVideo("C:/FaceBookScrape/Data/" + username + "/Videos/" + number + ".mp4", videoSrcList.get(i));
        }
        System.out.println("videos downloaded successfully");
              driver.findElement(By.xpath("//span[@class='l61y9joe j8otv06s a1itoznt fvlrrmdj svz86pwt jrvjs1jy a53abz89 okqr6zti']")).click();
         return driver;
    }
}
