package test_flow.global;

import models.components.global.footer.FooterColsComponent;
import models.components.global.footer.FooterComponent;
import models.components.global.header.topmenu.TopMenuComponent;
import models.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import url.Urls;

import static models.components.global.header.topmenu.TopMenuComponent.MainCatItem;
import static models.components.global.header.topmenu.TopMenuComponent.CatItemComponent;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(){
        BasePage basePage = new BasePage(driver);
        FooterComponent footerComponent = basePage.footerComp();
        verifyInformationColumn(footerComponent.informationColsComponent());
//        verifyCustomerServiceColumn();
    }

    public void verifyInformationColumn(FooterColsComponent footerColsComponent){
        //List<String> expectedLinkTexts = new ArrayList<>();
        String baseUrl = Urls.baseUrl;
        List<String> expectedLinkTexts =
                Arrays.asList("Sitemap", "Shipping & Returns", "Privacy Notice",
                        "Conditions of Use", "About us", "Contact us");
        //List<String> expectedHrefs = new ArrayList<>();
        List<String> expectedHrefs = Arrays.asList(baseUrl+"/sitemap",
                baseUrl+"/shipping-returns", baseUrl+"/privacy-policy", baseUrl+"/conditions-of-use",
                baseUrl+"/about-us", baseUrl+"/contactus" );
        verifyFooterColumn(footerColsComponent, expectedLinkTexts, expectedHrefs);
    }

    public void verifyProductCatFooterComponent(){
        //randomly pickup an item
        BasePage basePage = new BasePage(driver);
        TopMenuComponent topMenuComponent = basePage.topMenuComponent();
        List<MainCatItem> mainCatItemsElem = topMenuComponent.mainItemElms();
        if(mainCatItemsElem.isEmpty()){
            Assert.fail("[ERR] There is no item on top menu!");
        }
        //randomly pick a parent
        //MainCatItem randomMainCatItemElm =
        //        mainCatItemsElem.get(new SecureRandom().nextInt(mainCatItemsElem.size()));

        MainCatItem randomMainCatItemElm = mainCatItemsElem.get(0);
        String randomCatHref = randomMainCatItemElm.mainCatItemLinkElm().getAttribute("href");

        //in ra tên của Cat item dc click
        System.out.println(randomMainCatItemElm.getComponent().getText());
        //get sublist
        List<CatItemComponent> catItemComponents = randomMainCatItemElm.catItemComp();

        //Neu Main Category link k cos sub-list thì click link main category
        if(catItemComponents.isEmpty()){
            randomMainCatItemElm.mainCatItemLinkElm().click();
        }else {
            int randomIndex = new SecureRandom().nextInt(catItemComponents.size());
            CatItemComponent randomCatItemComponents=catItemComponents.get(randomIndex);
            System.out.println(randomCatItemComponents.getComponent().getText());
            randomCatHref= randomCatItemComponents.getComponent().getAttribute("href");
            randomCatItemComponents.getComponent().click();
        }

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlContains(randomCatHref));
        }catch (Exception e){
            e.printStackTrace();
        }


        //Verify footer component in Product Category page
        verifyFooterComponent();
    }
    public void verifyFooterColumn(
            FooterColsComponent footerColsComponent, List<String> expectedLinkText, List<String> expectedHrefs){
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinkHref = new ArrayList<>();
        for(WebElement link: footerColsComponent.linksElm()){
            actualLinkTexts.add(link.getText().trim());
            actualLinkHref.add(link.getAttribute("href"));
            System.out.println(link.getAttribute("href"));
        }

        if(actualLinkTexts.isEmpty() || actualLinkHref.isEmpty()){
            Assert.fail("[ERR] Text or hyperlinks is empty in footer column!");
        }
        //verify linktext
        Assert.assertEquals(actualLinkTexts, expectedLinkText,
                "[ERR] Actual and expected link texts are different!");

        //verify hrefs
        Assert.assertEquals(actualLinkHref, expectedHrefs,
                "[ERR] Actual and expected link texts are different!");

    }


}
