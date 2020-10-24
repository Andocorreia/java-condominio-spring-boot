package fixture.entity;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.core.enums.TipoEndereco;
import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.entity.PessoaEntity;

public class EnderecoEntityFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(EnderecoEntity.class).addTemplate("valid1", new Rule() {
			{
				add("id", new Long(1));
				add("pessoaId", one(PessoaEntity.class, "valid1"));
				add("tipo", TipoEndereco.RESIDENCIAL);
				add("rua", "Rua teste");
				add("numero", "123");
				add("complemento", "Complemento");
				add("cep", "09841125");
				add("bairro", "Bairro Teste");
				add("cidade", "Cidade Teste");
				add("uf", "SP");
				add("pais", "Brasil");
			}
		});

		Fixture.of(EnderecoEntity.class).addTemplate("valid2", new Rule() {
			{
				add("id", new Long(3));
				add("pessoaId", one(PessoaEntity.class, "valid3"));
				add("tipo", TipoEndereco.COMERCIAL);
				add("rua", "Rua teste 2");
				add("numero", "1232");
				add("complemento", "Complemento2");
				add("cep", "098411252");
				add("bairro", "Bairro Teste2");
				add("cidade", "Cidade Teste2");
				add("uf", "SP2");
				add("pais", "Brasil2");
			}
		});

		Fixture.of(EnderecoEntity.class).addTemplate("valid3", new Rule() {
			{
				add("id", new Long(2));
				add("pessoaId", one(PessoaEntity.class, "valid3"));
				add("tipo", TipoEndereco.CORRESPONDENCIA);
				add("rua", "Rua teste 3");
				add("numero", "1233");
				add("complemento", "Complemento3");
				add("cep", "098411253");
				add("bairro", "Bairro Teste3");
				add("cidade", "Cidade Teste3");
				add("uf", "SP3");
				add("pais", "Brasil3");
			}
		});

	}

}
