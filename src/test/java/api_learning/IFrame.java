package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectEx;
import url.Urls;

public class IFrame implements Urls {
    public static void main(String[] args) {
        //get a Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the page
            driver.get(baseUrl.concat(iframeSlug));
            System.out.println(baseUrl.concat(iframeSlug));

            //locate the iframe
            By iframeSel = By.cssSelector("[id$='ifr']");
            WebElement iframeElm = driver.findElement(iframeSel);

            //Switch to the  iframe
            driver.switchTo().frame(iframeElm);

            //locate the element inside the iframe
            WebElement editorInputElm = driver.findElement(By.id("tinymce"));
            editorInputElm.clear();
            editorInputElm.sendKeys("Hello Iframe here");

            //Switch back to the default content
            driver.switchTo().defaultContent();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
