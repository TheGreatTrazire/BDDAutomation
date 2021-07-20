package Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSetup {
    protected static ChromeDriver drive;
    protected static ChromeOptions options;
    protected static WebDriverWait wait;

    public static ChromeDriver getDriver(){
        return drive;
    }

    public void openBrowser(String site) throws Exception{
        options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-extensions", "--no-sandbox" , "--ignore-ssl-errors");
        drive = new ChromeDriver(options);
        drive.get(site);
        Thread.sleep(1000);
    }
    public void closeBrowser(){
        drive.quit();
    }

    public void acceptAlert() throws Exception{
        drive.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    public void goesToSite(String site) throws Exception{
        drive.navigate().to(site);
        Thread.sleep(1000);
    }
}
