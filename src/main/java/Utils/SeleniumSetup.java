package Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSetup {
    protected ChromeDriver drive;
    protected ChromeOptions options;
    protected WebDriverWait wait;

    public void openBrowser(String site) throws Exception{
        options = new ChromeOptions();
        options.addArguments("--window-size\\=1440,900", "--disable-extensions", "--no-sandbox" , "--ignore-ssl-errors");
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
}
