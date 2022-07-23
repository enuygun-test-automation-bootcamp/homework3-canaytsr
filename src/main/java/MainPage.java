import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class MainPage {
    public static void main(String[] args) {

        String url="https://www.enuygun.com";

        Chrome_Driver driverChrome = new Chrome_Driver();//create new Driver
        driverChrome.setUrl(url);//set url
       // driverChrome.profileSet();//set the profile
        driverChrome.setDriver();//driver's type is set to a Chrome
        driverChrome.maximizePage();//page maximized
        driverChrome.OpenSignInPage();//open sigin page
        driverChrome.closeLogin();//retun homepage
        driverChrome.waitPage(30);//wait 30 second
        driverChrome.OpenSignUpPage();//open signup page
        driverChrome.closePage();//close driver


        Firefox_Driver driverFirefox = new Firefox_Driver();//create new Driver
        driverFirefox.setUrl(url);//set page url
        driverFirefox.setDriver();//driver's type is set to a Firefox
        driverFirefox.maximizePage();//page maximized
        driverFirefox.OpenSignInPage();//open signin page
        driverFirefox.waitPage(30);//wait 30 second
        driverFirefox.OpenSignUpPage();//open signup page
        driverFirefox.closePage();//close driver




        /* Drivers class */
        Path resourceDirectory = Paths.get("src","main","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();

        Drivers driver = new Drivers();//create new driver
        driver.SetDriver(DriverType.CHROME,absolutePath);//set driver type to chrome
        driver.Maximized();//maximized page
        driver.GetHomePage(url);//set driver url
        driver.OpenLoginPage();//get login page
        driver.closeChromeLogin();//return main page
        driver.OpenRegisterPage();//open register page
        driver.waitPage(30);//wait 30 second
        driver.closeDriver();//close driver


        Drivers driver2 = new Drivers();//create new driver
        driver2.SetDriver(DriverType.FIREFOX ,absolutePath);//set driver type to firefox
        driver2.GetHomePage(url);//set driver url
        driver2.OpenLoginPage();//get login page
        driver2.OpenRegisterPage();//get register page
        driver2.closeDriver();//close driver



    }
}
