package unitario;

import org.junit.jupiter.api.BeforeAll;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class ApplicationUnitTests {

	@BeforeAll
	public static void beforeAll() {
		FixtureFactoryLoader.loadTemplates("fixture");
	}

}


