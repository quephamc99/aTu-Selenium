package models.components.global.footer;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value =".column.my-account")
public class MyAccountColsComponent extends FooterColsComponent{
    public MyAccountColsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
