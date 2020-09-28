package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	private static WebDriver driver;
	static Properties ps;

	public static WebDriver testBase() {
		try {
			FileInputStream fis = new FileInputStream("D:\\HARDIK\\Work\\Automation\\LuxshPayrollHelpDesk\\config.properties");
			ps = new Properties();
			ps.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		String browsername = ps.getProperty("browser");
		System.out.println(browsername);
		WebDriver driver = null;
		if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\HARDIK\\Work\\Automation\\LuxshPayrollHelpDesk\\drivers\\IEDriverServerWin32.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\HARDIK\\Work\\Automation\\LuxshPayrollHelpDesk\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		System.out.println(ps.getProperty("url"));
		driver.get(ps.getProperty("url"));
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
