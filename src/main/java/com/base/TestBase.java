package com.base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.util.Units;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.events.EventFiringWebDriver;

	public class TestBase {

		public static Properties prop;
		FileInputStream file;
		public static WebDriver driver;
		public TestBase() {

			try {
				file = new FileInputStream("C:\\Users\\manikanta\\git\\Ecom_mayAutomation\\src\\main\\java\\configproperties\\Configprop");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			prop = new Properties();

			try {
				prop.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}

		public void initialization() {

			String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equals("Edge")) {
				driver = new EdgeDriver();
			} else if (browsername.equals("firefox")) {

				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			//extentreports.flush();

		}

	}
