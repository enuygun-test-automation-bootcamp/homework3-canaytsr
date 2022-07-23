import org.openqa.selenium.firefox.FirefoxDriver;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Firefox_Driver extends Driver {
    String absolutePath;

    @Override
    public void setDriver() {//override the interfaces set driver method
        Path resourceDirectory = Paths.get("src","main","resources");
        this.absolutePath = resourceDirectory.toFile().getAbsolutePath();

        try {// set the property and check if there is a valid exe file in that path.
            System.setProperty("webdriver.gecko.driver",this.absolutePath+"/binary/geckodriver.exe");

        } catch(IllegalStateException e){
            System.out.println("Driver not found"+ e.getMessage());
        }

        this.driver = new FirefoxDriver();//set driver to firefox driver
        this.driver.get(this.url);//set url

    }


}