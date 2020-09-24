package test;
import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest{
	 
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){ 
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
		
	}
 
	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Daniela");
		page.setSobrenome("Pochini");
		page.setSexoFeminino();
		page.setComidaPizza();
		page.setEscolaridade("Especializacao");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Daniela", page.obterNomeCadastro());
		Assert.assertEquals("Pochini", page.obterSobrenomeCadastro());
		Assert.assertEquals("Feminino", page.obterSexoCadastro());
		Assert.assertEquals("Pizza", page.obterComidaCadastro());
		Assert.assertEquals("especializacao", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Natacao", page.obterEsportesCadastro());
	}
}
