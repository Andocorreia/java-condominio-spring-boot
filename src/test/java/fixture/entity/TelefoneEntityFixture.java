package fixture.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.core.enums.TipoTelefone;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.entity.TelefoneEntity;

public class TelefoneEntityFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(TelefoneEntity.class).addTemplate("valid1", new Rule() {
			{
				add("id", new Long(1));
				add("pessoaId", one(PessoaEntity.class, "valid2"));
				add("numero", "12345");
				add("complemento", "Complemento");
				add("tipo", TipoTelefone.CELULAR);
			}
		});

		Fixture.of(TelefoneEntity.class).addTemplate("valid2", new Rule() {
			{
				add("id", new Long(3));
				add("pessoaId", one(PessoaEntity.class, "valid1"));
				add("numero", "123452");
				add("complemento", "Complemento 2");
				add("tipo", TipoTelefone.COMERCIAL);
			}
		});

		Fixture.of(TelefoneEntity.class).addTemplate("valid3", new Rule() {
			{
				add("id", new Long(2));
				add("pessoaId", one(PessoaEntity.class, "valid3"));
				add("numero", "123453");
				add("complemento", "Complemento 3");
				add("tipo", TipoTelefone.RECADO);
			}
		});

	}

}
