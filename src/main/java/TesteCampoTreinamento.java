import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste");
		Assert.assertEquals("Teste", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		driver.quit();
	}
	
	
	@Test
	public void deveInteragircomTextArea() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste Dois");
		Assert.assertEquals("Teste Dois", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		
	}
}
