package POM_tests;

import drivers.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginTestMod02 {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.baseUrl.concat(Urls.loginSlug));
            LoginPageMod01 loginPage = new LoginPageMod01(driver);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
