package drivers;

import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation ="";
        if(OS.isFamilyMac()){
            chromeDriverLocation = currentProjectLocation.concat("/src/test/resources/drivers/chromedriver_112.exe");
        }
        if(OS.isFamilyWindows()){
            chromeDriverLocation = currentProjectLocation.concat("\\src\\test\\resources\\drivers\\chromedriver_112.exe");
        }

        if(chromeDriverLocation.isEmpty()){
            throw  new IllegalArgumentException("Can not detect OS type! ");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        System.out.println(chromeDriverLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        // add this argument --remote-allow-origins=*, if not, only a blank browser is launched and it does nt proceed next steps
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return  driver;
    }
}
