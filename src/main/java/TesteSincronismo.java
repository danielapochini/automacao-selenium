import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteSincronismo {
 
	private DSL dsl;
	
	@Before
	public void inicializa() { 
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void deveUtilizarEsperaFixa() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(5000); //espera fixa
		dsl.escrever("novoCampo", "Deu certo?");
	}
	
	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //espera implicita
		dsl.clicarBotao("buttonDelay");
		dsl.escrever("novoCampo", "Deu certo?");
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo"))); 
		//melhor forma, mais controles da espera, apenas quando necessitar, testes mais r�pidos
		dsl.escrever("novoCampo", "Deu certo?");
	}
	
}
