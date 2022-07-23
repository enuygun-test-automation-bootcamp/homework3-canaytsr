import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Chrome_Driver extends Driver{
    String absolutePath;
    ChromeOptions options = new ChromeOptions(); //create options

    public void setAbsolutePath(String absolutePath) {

        this.absolutePath = absolutePath; //set absolutePath
    }

    @Override
    public void setDriver() { //override the interfaces set driver method
        Path resourceDirectory = Paths.get("src", "main", "resources");
        this.absolutePath = resourceDirectory.toFile().getAbsolutePath(); //set chrome path
        try { // set the property and check if there is a valid exe file in that path
            System.setProperty("webdriver.chrome.driver", this.absolutePath + "/binary/chromedriver.exe");

        } catch (IllegalStateException e) {
            System.out.println("Driver not found" + e.getMessage());
        }

        this.driver = new ChromeDriver();//set driver to chrome driver
        this.driver.get(this.url);//set url
    }

    public void maximizedChrome() {
        // this.options.addArguments("--start-maximized");

    }

    public void profileSet() {//set chrome profile
        /*To use the profile feature, we need a value
        between 100 or 101.0 for the chrome version
        and 100 to 85 for the CDP version.
        */

        this.options.addArguments("user-data-dir=C:\\Users\\LENOVO\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        this.driver= new ChromeDriver(options);//set chrome profile

    }
}