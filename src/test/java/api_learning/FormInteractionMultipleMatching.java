package api_learning;

import dev.failsafe.internal.util.Assert;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        try {
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            // get the list of elements
            List<WebElement> elementList = driver.findElements(By.cssSelector("input"));
            if (!elementList.isEmpty()) {
                elementList.get(USERNAME_INDEX).sendKeys("abc");
                elementList.get(PASSWORD_INDEX).sendKeys("pwd");
            } else {
                //Assert.fail
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("abc");
        }

    }


}
