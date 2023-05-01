package test_flow.global;

import org.openqa.selenium.WebDriver;

public class FooterTestFlow {
    private WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent(){
        verifyInfomationColumn();
        verifyCustomerServiceColumn();
    }
}
