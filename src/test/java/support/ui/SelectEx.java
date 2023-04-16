package support.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectEx extends Select {
    public  SelectEx(WebElement element){
        super(element);
    }

    public void selectByIndex(int index){
        selectByIndex(index);
    }
}
