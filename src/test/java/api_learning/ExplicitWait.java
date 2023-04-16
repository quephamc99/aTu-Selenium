package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitMoreThanOneTab;
import url.Urls;

import java.time.Duration;
import java.util.List;

public class ExplicitWait {
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.id("password");
    private final static By loginButtonSel = By.cssSelector("button");
    public static void main(String[] args) {
        //get a Chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the page
            driver.get(Urls.baseUrl.concat(Urls.loginSlug));
            By taolaoSel = By.cssSelector(".teo");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(new WaitMoreThanOneTab());


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

