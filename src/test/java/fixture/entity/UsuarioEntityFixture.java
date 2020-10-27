package fixture.entity;

import java.time.LocalDate;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.entity.UsuarioEntity;

public class UsuarioEntityFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(UsuarioEntity.class).addTemplate("valid", new Rule() {
			{
				add("id", new Long(1));
				add("pessoaId", one(PessoaEntity.class, "valid1"));
				add("usuario", "UsuarioTeste");
				add("senha", "SenhaTeste");
				add("ultimaAlteracaoSenha", LocalDate.now());
				add("bloqueado", false);
			}
		});

	}

}
