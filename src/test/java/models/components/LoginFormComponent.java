package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value="#login")
public class LoginFormComponent {
    private final WebDriver driver;
    private final static By usernameSel = By.id("username");
    private final static By passwordSel = By.cssSelector("password");
    private final static By loginBtnSel= By.cssSelector("[type='submit']");

    public LoginFormComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void inputusername(String username){
        driver.findElement(usernameSel).sendKeys(username);
    }

    public void inputpassword(String password){
        driver.findElement(passwordSel).sendKeys(password);
    }

    public void clickloginButton(){
        driver.findElement(loginBtnSel).click();
    }
}
