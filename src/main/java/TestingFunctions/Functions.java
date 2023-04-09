package TestingFunctions;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Functions {

    String browserType="Chrome";

    public static String url="https://subscribe.stctv.com/sa-en";

    public static WebDriver driver;
    public static String currency;
    String driverPath = System.getProperty("user.dir");
    public WebDriver driverSetup (String url){


        if (browserType == "Chrome") {//For chrome driver call

            System.setProperty("webdriver.http.factory", "jdk-http-client");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");


            System.setProperty("webdriver.chrome.driver", driverPath + "\\chromedriver.exe");

            driver = new ChromeDriver();
        }

        if (browserType == "FireFox") {//For firefox driver call
            System.setProperty("webdriver.gecko.driver", driverPath + "\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        if (browserType == "Edge") {
            System.setProperty("webdriver.edge.driver", driverPath + "\\geckodriver.exe");
            driver = new EdgeDriver();
        }


        driver.navigate().to(url); //Navigate to the entered url in the top
        driver.manage().window().maximize(); //Enlarge the browser page

        return driver;
    }
public static String language;
    public String countryCurrency  (String  country){
if (language =="AR"){ switch (country){
    case "السعودية":
        currency="ريال سعودي";
        break;
    case "الكويت":
        currency="دينار كويتي";
        break;

    case "البحرين":
        currency="\u202Bدينار بحريني";
        break;}}
else{
        switch (country){
            case "KSA":
                currency="SAR";
                break;
            case "Kuwait":
                currency="KWD";
                break;

            case "Bahrain":
                currency="BHD";
                break;
        }
    }return currency;}

    public void changeCountry(String  country){
        driver.findElement(By.xpath("//a[@id='country-btn']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'"+country+"')]")).click();

    }
}
