package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Constants;

public class TestBase {

	private static WebDriver driver;

	ChromeOptions options = new ChromeOptions();
	//options.setExperimentalOption("useAutomationExtension", false);

	static Properties ps;

	public static WebDriver testBase() {
		try {
			FileInputStream fis = new FileInputStream(Constants.PROJECTPATH + "\\config.properties");
			ps = new Properties();
			ps.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browsername = ps.getProperty("browser");
		System.out.println(browsername);
		WebDriver driver = null;
		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.PROJECTPATH + "\\drivers\\IEDriverServerWin32.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",Constants.PROJECTPATH + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//System.out.println(ps.getProperty(Constants.BASEURL));
		//driver.get(ps.getProperty(Constants.BASEURL));
		System.out.println(Constants.BASEURL);
		driver.get(Constants.BASEURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
