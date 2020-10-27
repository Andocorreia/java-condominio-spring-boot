package fixture.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.core.enums.PerfilUsuario;
import com.condominio.backend.entity.PerfilEntity;

public class PerfilEntityFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(PerfilEntity.class).addTemplate("valid1", new Rule() {
			{
				add("id", new Long(1));
				add("nome", PerfilUsuario.ADMINISTRADOR);
			}
		});

		Fixture.of(PerfilEntity.class).addTemplate("valid2", new Rule() {
			{
				add("id", new Long(2));
				add("nome", PerfilUsuario.PORTARIA);
			}
		});

	}

}
