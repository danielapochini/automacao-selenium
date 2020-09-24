package suites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.TesteAjax;
import test.TesteAlert;
import test.TesteCadastro;
import test.TesteCampoTreinamento;
import test.TesteRegrasCadastro;
import test.TesteSincronismo;

@RunWith(Suite.class)

@SuiteClasses({
	TesteCadastro.class,
	TesteAlert.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamento.class,
	TesteAjax.class,
	TesteSincronismo.class
})
public class SuiteTeste {

}
