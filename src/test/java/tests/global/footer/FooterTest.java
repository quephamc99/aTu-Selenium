package tests.global.footer;

import drivers.DriverFactory;
import models.components.global.footer.InformationColsComponent;
import models.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_flow.global.FooterTestFlow;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class FooterTest {


    @Test
    public static void testFooterHomepage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        try{
            HomePage homePage = new HomePage(driver);
            InformationColsComponent informationColsComponent
                    = homePage.footerComp().informationColsComponent();
            System.out.println(informationColsComponent.headerElm().getText());
            informationColsComponent.linksElm().forEach(link ->{
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));
            });
        }catch (Exception ignored){
            ignored.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public static void testFooterCategory() {
        String actualResult="Teo";
        String expected = "ti";
        Assert.assertEquals(actualResult, expected, "[ERR] The welcome message is not correct!");
    }

    @Test
    public static void testFooterFlow() {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();

    }

    @Test
    public static void testSoftAssert() {
        String actualResult="Teo";
        String expected = "Ti";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult, expected, "[ERR] The soft-assert work but the message is printed!");
        System.out.println("Hello");
        softAssert.assertAll();
    }

}
