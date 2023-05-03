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
    public static void testFooterFlow() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get("https://demowebshop.tricentis.com/");
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            //footerTestFlow.verifyFooterComponent();
            footerTestFlow.verifyProductCatFooterComponent();
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();

    }


}
