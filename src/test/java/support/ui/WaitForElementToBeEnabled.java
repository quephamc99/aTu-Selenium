package support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForElementToBeEnabled implements ExpectedCondition<Boolean>{
    private By selector;

    public WaitForElementToBeEnabled(By selector) {
        this.selector = selector;
    }

    @Override
    public Boolean apply(WebDriver driver){
        return driver.findElement(selector).isEnabled();
    }

    @Override
    public String toString(){
        return "Element located by: " + this.selector.toString() + "is not enabled!";
    }
}


