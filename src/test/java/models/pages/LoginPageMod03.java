package models.pages;

import models.components.LoginFormComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PublicKey;

public class LoginPageMod03 {
    private final WebDriver driver;
    public LoginPageMod03(WebDriver driver) {
        this.driver = driver;
    }
    public LoginFormComponent loginFormComp(){
        return new LoginFormComponent(driver);
    }
}
