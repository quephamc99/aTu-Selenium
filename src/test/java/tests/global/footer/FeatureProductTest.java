package tests.global.footer;

import drivers.DriverFactory;
import models.components.global.footer.InformationColsComponent;
import models.components.global.product.ProductItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class FeatureProductTest {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            testProductTitle(driver);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void testProductTitle(WebDriver driver) {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage(driver);
        List<ProductItemComponent> productItemComponents=
                homePage.productGridComponent().productItemComps();
        productItemComponents.forEach(productItemComp ->{
            System.out.println(productItemComp.productTitleElm().getText());
        });
        driver.quit();
    }

}
