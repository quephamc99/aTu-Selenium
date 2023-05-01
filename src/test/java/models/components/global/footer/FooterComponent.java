package models.components.global.footer;

import com.oracle.jrockit.jfr.management.NoSuchRecordingException;
import models.components.Component;
import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(value=".footer")
public class FooterComponent extends Component {
    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public InformationColsComponent informationColsComponent(){
        return findComponent(InformationColsComponent.class, driver);
    }

    public CustomerServiceColsComponent customerServiceColsComponent(){
        return findComponent(CustomerServiceColsComponent.class, driver);
    }

    public MyAccountColsComponent myAccountColsComponent(){
        return findComponent(MyAccountColsComponent.class, driver);
    }

    public FollowUsColsComponent followUsColsComponent(){
        return findComponent(FollowUsColsComponent.class, driver);
    }
}
