package fixture.request;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.request.LoginRequest;

public class LoginRequestFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(LoginRequest.class).addTemplate("valid", new Rule() {
			{
				add("usuario", "usuarioTeste");
				add("senha", "usuarioSenha");
			}
		});

	}

}
