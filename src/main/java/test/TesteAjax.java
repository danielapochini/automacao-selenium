package test;
import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseTest;
import core.DSL;

public class TesteAjax extends BaseTest{
 
	private DSL dsl;
	
	@Before
	public void inicializa() { 
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
 
	@Test
	public void testAjax(){
		dsl.escrever("j_idt727:name", "Teste");
		dsl.clicarBotao("j_idt727:j_idt730");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo"))); 
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt807_start")));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt727:display"));
	}
}
