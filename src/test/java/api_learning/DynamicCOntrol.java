package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementToBeEnabled;
import url.Urls;

import java.time.Duration;

public class DynamicCOntrol implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            driver.get(baseUrl.concat(dynamicControls));

            //define parent locators | 2 forms | checkbox form + input form
            By checkboxFormSel = By.id("checkbox-example");
            By inputFromSel = By.id("input-example");

            //checkbox form interaction
            WebElement checkboxFormElm = driver.findElement(checkboxFormSel);
            WebElement checkboxElm = checkboxFormElm.findElement(By.tagName("input"));

            if(!checkboxElm.isSelected())
                checkboxElm.click();

            // input form interaction
            WebElement inputFormElm = driver.findElement(inputFromSel);
            WebElement inputFieldElm = inputFormElm.findElement(By.tagName("input"));
            WebElement inputButtonElm = inputFormElm.findElement(By.tagName("button"));
            if(!inputFieldElm.isEnabled()){
                inputButtonElm.click();
            }

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
//            inputFieldElm.sendKeys("Tui ten là Que.");

            // try to customize to wait for the input field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(new WaitForElementToBeEnabled(By.cssSelector("#input-example input")));
            inputFieldElm.sendKeys("Tui ten là Que.");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
