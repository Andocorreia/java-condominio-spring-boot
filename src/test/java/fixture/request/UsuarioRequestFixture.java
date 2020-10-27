package fixture.request;

import java.util.Arrays;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.request.UsuarioRequest;

public class UsuarioRequestFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(UsuarioRequest.class).addTemplate("valid", new Rule() {
			{
				add("usuario", "usuario");
				add("pessoaId", new Long(1));
				add("senha", "senhaUsuario");
				add("perfis",Arrays.asList("ADMINISTRADOR", "portaria"));
			}
		});

	}

}
