package api_learning;
import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation ="";
        if(OS.isFamilyMac()){
            chromeDriverLocation = currentProjectLocation.concat("/src/test/resources/drivers/chromedriver_111.exe");
        }
        if(OS.isFamilyWindows()){
            chromeDriverLocation = currentProjectLocation.concat("\\src\\test\\resources\\drivers\\chromedriver_111.exe");
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
        driver.manage().window().maximize();
        driver.get("https://learn.sdetpro.com/");
        //debug
        try{
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();


    }
}
