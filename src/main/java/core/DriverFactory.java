package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			switch(Propriedades.browser) {
			case FIREFOX: driver = new FirefoxDriver(); break;
			case CHROME: driver = new ChromeDriver(); break;
			} 
			driver.manage().window().maximize(); 
		}
		return driver;	//retorna a mesma instancia de driver criada anteriormente
	}
	
	public static void killDriver() {
		if (driver != null) { 
			driver.quit();
			driver = null; 
		}
		// depois que matar um driver, se alguem pedir de novo, uma nova instância será criada naquele momento
	}
}
