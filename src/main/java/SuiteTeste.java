import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
