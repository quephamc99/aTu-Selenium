package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class MouseHoverAndNarrowDownSearchingScope implements Urls {
    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");
    public static void main(String[] args) {
        //get a Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the page
            driver.get(baseUrl.concat(mouseHoverSlug));
            System.out.println(baseUrl.concat(mouseHoverSlug));

            //target parent elements
            List<WebElement> figureElms = driver.findElements(figureSel);
            if(figureElms.isEmpty())
            {
                throw new RuntimeException("There is no profile image displayed!");
            }

            //define an Actions object
            Actions action = new Actions(driver);
            for (WebElement figureElm : figureElms) {
                WebElement profileNameElm = figureElm.findElement(profileNameSel);
                WebElement profileLinkElm = figureElm.findElement(profileLinkSel);

                //before mouse hover
                System.out.println(profileNameElm.getText() + ": " +profileNameElm.isDisplayed());
                System.out.println(profileLinkElm.getText() + ": " +profileLinkElm.isDisplayed());

                //Mouse hover
                action.moveToElement(figureElm).perform();

                //after mouse hover
                System.out.println(profileNameElm.getText() + ": " +profileNameElm.isDisplayed());
                System.out.println(profileLinkElm.getText() + ": " +profileLinkElm.isDisplayed());

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

