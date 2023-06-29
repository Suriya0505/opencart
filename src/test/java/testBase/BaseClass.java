package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportManager;

public class BaseClass  {

	public static WebDriver driver;
	public org.apache.logging.log4j.Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass(groups = {"Sanity", "Master"})
	@Parameters("browser")
	public void setup(String br)
	{
//		ChromeOptions options=new ChromeOptions();
//		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
//		loading property file
		
		rb = ResourceBundle.getBundle("config");
		
		logger = LogManager.getLogger(this.getClass());
		
		if(br.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			}
		
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\Suriya\\Softwares\\geckodriver.exe"); // Setting system properties of FirefoxDriver
			driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		driver.get("http://localhost/opencart/upload/index.php");
		driver.get(rb.getString("URL"));
		
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups = {"Sanity", "Master"})
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	public String randomString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
		
	}
	
	public String randomNumber() {
		
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return generatedNumber;
		
	}
	
	
	public String alphaNumeric() {
		
		String generatedAlphaNumeric = RandomStringUtils.randomAlphanumeric(10);
		return generatedAlphaNumeric;
	}
	
	
	public static String takeScreenshot(WebDriver driver) {

		String base64Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

		return base64Screenshot;

	}

	public static void addScreenshot() {

		ExtentReportManager.test.addScreenCaptureFromBase64String(takeScreenshot(driver));

	}
	
	
	
}
