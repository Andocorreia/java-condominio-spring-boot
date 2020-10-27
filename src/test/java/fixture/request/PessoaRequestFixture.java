package fixture.request;

import java.util.Arrays;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.core.enums.Classificacao;
import com.condominio.backend.request.PessoaRequest;
import com.condominio.backend.request.PessoaRequest.Endereco;
import com.condominio.backend.request.PessoaRequest.Telefone;

public class PessoaRequestFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(PessoaRequest.class).addTemplate("valid", new Rule() {
			{
				add("nome", "André de Oliveira");
				add("dataNascimento", "1984-10-27");
				add("cpf", "1231231232");
				add("rg", "45678978982");
				add("estadoCivil", "casado");
				add("email", "email@email.comb");
				add("sexo", "M");
				add("classificacao", Classificacao.PROPRIETARIO_MORADOR.getDescricao());
				add("enderecos", has(3).of(Endereco.class, "endereco1", "endereco2", "endereco3"));
				add("telefones", has(3).of(Telefone.class, "telefone1", "telefone2", "telefone3"));
				add("apartamentos", Arrays.asList(new Long(1),new Long(2),new Long(3)));
			}
		});

		Fixture.of(Telefone.class).addTemplate("telefone1", new Rule() {
			{
				add("numero", "123456789");
				add("complemento", "Teste");
				add("tipo", "Residencial");
			}
		});

		Fixture.of(Telefone.class).addTemplate("telefone2", new Rule() {
			{
				add("numero", "98765432");
				add("complemento", "Teste 2");
				add("tipo", "Comercial");
			}

		});

		Fixture.of(Telefone.class).addTemplate("telefone3", new Rule() {
			{
				add("numero", "147852369");
				add("complemento", "Teste 3");
				add("tipo", "recado");
			}
		});

		Fixture.of(Endereco.class).addTemplate("endereco1", new Rule() {
			{
				add("tipo", "RESIDENCIAL");
				add("rua", "Rua teste");
				add("numero", "123");
				add("complemento", "Complemento Teste");
				add("cep", "09841560");
				add("bairro", "bairro Teste");
				add("cidade", "Cidade Teste");
				add("uf", "SP");
				add("pais", "Brasil");
			}
		});

		Fixture.of(Endereco.class).addTemplate("endereco2", new Rule() {
			{
				add("tipo", "Comercial");
				add("rua", "Rua teste 2");
				add("numero", "1232");
				add("complemento", "Complemento Teste 2");
				add("cep", "09841560");
				add("bairro", "bairro Teste 2");
				add("cidade", "Cidade Teste 2");
				add("uf", "SP");
				add("pais", "Brasil");
			}
		});

		Fixture.of(Endereco.class).addTemplate("endereco3", new Rule() {
			{
				add("tipo", "correspondencia");
				add("rua", "Rua teste 3");
				add("numero", "1233");
				add("complemento", "Complemento Teste 3");
				add("cep", "09841560");
				add("bairro", "bairro Teste 3");
				add("cidade", "Cidade Teste 3");
				add("uf", "SP");
				add("pais", "Brasil");
			}
		});
	}

}
