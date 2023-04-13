package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Form_Interaction {
    public static void main(String[] args) {
        //get a chrome version
        WebDriver driver = DriverFactory.getChromeDriver();

        //navigate to the expected page
        driver.get("https://the-internet.herokuapp.com/login");

        try{
            //define element
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginSel = By.cssSelector("[type=\"submit\"]");
            // find elements
            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginElem = driver.findElement(loginSel);

            //interaction
            usernameElem.clear();
            usernameElem.sendKeys("tomsmith");
            passwordElem.clear();
            passwordElem.sendKeys("SuperSecretPassword!");
        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
