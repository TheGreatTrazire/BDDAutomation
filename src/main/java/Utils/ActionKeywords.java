package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionKeywords extends SeleniumSetup{

    void waitElementUntilItVisible (WebElement element, int timeoutInSec){
        wait = new WebDriverWait(drive, timeoutInSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement findElementXpath(String id_xpath){
        WebElement element = drive.findElement(By.xpath(id_xpath));
        waitElementUntilItVisible(element, 10);
        return element;
    }

    public void clickElementXpath(String id_xpath) throws Exception{
        Thread.sleep(1000);
        Actions act = new Actions(drive);
        act.moveToElement(findElementXpath(id_xpath)).click().build().perform();
        Thread.sleep(1000);
    }

    public void inputText(String id_xpath, String text) throws Exception{
        Thread.sleep(1000);
        String a = findElementXpath(id_xpath).getAttribute("value");
        if(a != null){
            int x = a.length();
            while(x != 0){
                findElementXpath(id_xpath).sendKeys(Keys.BACK_SPACE);
                x--;
            }
        }
        findElementXpath(id_xpath).sendKeys(text);
        Thread.sleep(1000);
    }

    public void verifyElementVisible(String id_xpath) throws Exception{
        boolean find =  drive.findElement(By.xpath(id_xpath)).isDisplayed();

        if(!find){
            throw new java.lang.RuntimeException("Element is not visible");
        }
        Thread.sleep(1000);
    }

    public boolean isElementVisible(String id_xpath) throws Exception{
        boolean find =  drive.findElement(By.xpath(id_xpath)).isDisplayed();
        Thread.sleep(1000);
        return find;
    }

    public void selectFromDDL(String id_xpath) throws Exception{
        Thread.sleep(2000);
        Actions act = new Actions(drive);
        act.moveToElement(findElementXpath(id_xpath)).click().build().perform();
        Thread.sleep(1000);
    }
}
