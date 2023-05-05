package tests.global.footer;

import drivers.DriverFactory;
import io.qameta.allure.Allure;
import models.components.global.footer.InformationColsComponent;
import models.pages.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test_flow.global.FooterTestFlow;
import tests.BaseTest;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FooterTest extends BaseTest {

    @Test
    public static void testHomePageFooter() {
        driver.get("https://demowebshop.tricentis.com/");
        Assert.fail("Make it failed!");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComponent();
    }
    @Test
    public static void testCategoryFooter() {
        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComponent();

    }

}
