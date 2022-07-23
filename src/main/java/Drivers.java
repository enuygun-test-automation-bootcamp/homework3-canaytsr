import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Drivers implements LoginRegisterPage {
    DriverType type;
    String url;
    WebDriver driver;
    boolean isButton = false;

    public void SetDriver(DriverType type , String absolutePath) {
        this.type = type;
        if (type.equals(DriverType.CHROME))
        {
            System.out.println("-----chrome-----");
            System.setProperty("webdriver.chrome.driver", absolutePath+"/binary/chromedriver.exe");
            this.driver = new ChromeDriver();
        }
        else if (type.equals(DriverType.FIREFOX))
        {
            System.out.println("------firefox-----");
            System.setProperty("webdriver.gecko.driver",absolutePath+"/binary/geckodriver.exe");
            this.driver = new FirefoxDriver();
        }
        else {
            System.out.println("invalid Driver Type");
        }

    }
    public WebDriver returnPage(){
         return this.driver;

    }

    public void GetHomePage(String url){
        this.url = url;
        this.driver.get(url);

    }
    public void waitPage(int second){

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
       // this.driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);

    }

    public void Maximized(){
        this.driver.manage().window().maximize();

    }

    @Override
    public void OpenLoginPage() {
        try {
            this.driver.findElement(By.id("ctx-LoginBtn")).click();
            System.out.println("login opened");
        } catch (NoSuchElementException e){
            System.out.println("Not Found Web Element" + e.getMessage());
        }
    }
    public void closeChromeLogin(){
        this.driver.get(this.url);
        System.out.println("login closed");

    }

    @Override
    public void OpenRegisterPage() {
        try {
            this.driver.findElement(By.id("ctx-RegisterBtn")).click();
            System.out.println("register opened");

        } catch (NoSuchElementException e){
            System.out.println("Not Found Web Element" + e.getMessage());
        }
    }
    public void closeDriver(){
        this.driver.quit();
        System.out.println("driver closed");

    }

}
