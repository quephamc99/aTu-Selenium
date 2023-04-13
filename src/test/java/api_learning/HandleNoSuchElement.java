package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandleNoSuchElement {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        Exception e = null;
        try {
            WebElement element = driver.findElement(By.cssSelector("invalidSelector"));

        }catch (NoSuchElementException noSuchElementException){
            e = noSuchElementException;
        }

        if(e ==null){
            //Assert.fail("The element abc still displayed.");
        }
    }
}
