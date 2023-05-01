package models.components.global.footer;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".column.customer-service")
public class CustomerServiceColsComponent extends FooterColsComponent{
    public CustomerServiceColsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
