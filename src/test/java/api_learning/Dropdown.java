package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectEx;
import url.Urls;

public class Dropdown implements Urls {
    public static void main(String[] args) {
        //get a Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the page
            driver.get(baseUrl.concat(dropdownSlug));
            System.out.println(baseUrl.concat(dropdownSlug));

            //dropdown locator $ element
            By dropdownSel = By.id("dropdown");
            WebElement dropdownElm = driver.findElement(dropdownSel);
            //select dropdown
            SelectEx select = new SelectEx(dropdownElm);
            //select option by the first index
            select.selectByIndex(1);

//            //select by visible text
//            select.selectByVisibleText("Option 1");
//            Thread.sleep(1000);
//
//            //select by index
//            select.selectByIndex(2);
//
//            //select by value
//            select.selectByValue("1");
//            Thread.sleep(1000);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
