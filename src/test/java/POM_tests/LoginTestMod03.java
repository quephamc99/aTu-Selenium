package POM_tests;

import drivers.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginTestMod03 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.baseUrl.concat(Urls.loginSlug));
            LoginPageMod03 loginPage = new LoginPageMod03(driver);
            LoginFormComponent loginFormComponent = loginPage.loginFormComp();
            loginFormComponent.inputusername("tomsmith");
            loginFormComponent.inputpassword("wrongpwd");
            loginFormComponent.clickloginButton();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
