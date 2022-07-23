import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver implements pageLogin,pageRegister {
    public WebDriver driver;
    String url;

    public Driver() {
    }

    public void setUrl(String url) { //set url
        this.url = url;

    }

    public void setDriver(){

    }
    public void waitPage(int second){ //wait the page
        //this.driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));

    }

    public void maximizePage(){
        this.driver.manage().window().maximize();// maximized the driver

    }
    @Override
    public void OpenSignInPage() {
        WebDriver driver1 ;//create new driver
        driver1 = this.driver;//copy this driver to new driver
        try { //control this web element is valid or not
            driver1.findElement(By.id("ctx-LoginBtn")).click();
            System.out.println("Signin Opened");
        } catch (NoSuchElementException e){
            System.out.println("Web Element Not Found" + e.getMessage());
        }
    }

    @Override
    public void OpenSignUpPage() {
        WebDriver driver2 ; //set driver
        driver2 = this.driver; //copy this driver to new driver
        try { //control this web element is valid or not
            driver2.findElement(By.id("ctx-RegisterBtn")).click();
            System.out.println("Signup Opened");
        } catch (NoSuchElementException e){
            System.out.println("Web Element Not Found" + e.getMessage());
        }

    }
    public void closePage(){
        this.driver.quit();//Close driver
        System.out.println("Driver Closed");

    }
    public void closeLogin(){
        this.driver.get(this.url); //get home page
        System.out.println("login closed");

    }
}
