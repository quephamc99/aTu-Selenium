package tests.global.footer;

import drivers.DriverFactory;
import models.components.global.footer.InformationColsComponent;
import models.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FooterTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testFooterHomepage(driver);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void testFooterHomepage(WebDriver driver) {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage(driver);
        InformationColsComponent informationColsComponent
                = homePage.footerComp().informationColsComponent();
        System.out.println(informationColsComponent.headerElm().getText());
        informationColsComponent.linksElm().forEach(link ->{
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });

        driver.quit();
    }

    private static void testFooterCategory(WebDriver driver) {

    }
}
