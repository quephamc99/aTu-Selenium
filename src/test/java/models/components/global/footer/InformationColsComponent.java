package models.components.global.footer;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value = ".column.information")
public class InformationColsComponent extends FooterColsComponent {
    public InformationColsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
