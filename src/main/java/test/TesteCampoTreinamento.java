package test;
import static core.DriverFactory.getDriver; 
 
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseTest;
import core.DSL; 

public class TesteCampoTreinamento extends BaseTest {
	 
	private DSL dsl;
	
	@Before
	public void inicializa(){  
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");	
		dsl = new DSL();
	}
	 
	@Test
	public void testeTextField() {
		dsl.escrever("elementosForm:nome", "Teste"); 
		Assert.assertEquals("Teste", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	
	@Test
	public void deveInteragircomTextArea() {
		dsl.escrever("elementosForm:sugestoes", "Teste Dois"); 
		Assert.assertEquals("Teste Dois", dsl.obterValorCampo("elementosForm:sugestoes"));	
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		dsl.clicarRadio("elementosForm:sexo:0"); 
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0")); 
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		dsl.clicarCheck("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isCheckMarcado("elementosForm:comidaFavorita:2")); 
	}
	
	@Test
	public void deveInteragirComCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void deveVerificarValoresCombo(){
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	}
	
	
	@Test
	public void deveVerificarValoresComboMultiplo(){
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
	}
	
	@Test
	public void deveInteragirComBotoes(){
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
	}
	
	@Test
	public void deveinteragirComLinks(){
		dsl.clicarLink("Voltar"); 
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void deveBuscarTextosNaPagina(){	
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				dsl.obterTexto(By.className("facilAchar")));
	}
	
	@Test
	public void testJavascript() { 
		dsl.executarJS("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
		dsl.executarJS("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		dsl.executarJS("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela(){
		dsl.clicarBotaoTabela("Escolaridade", "Mestrado", "Radio", "elementosForm:tableUsuarios");
	}
		
}
