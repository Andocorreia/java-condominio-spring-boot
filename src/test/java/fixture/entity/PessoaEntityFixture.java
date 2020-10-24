package fixture.entity;

import java.time.LocalDate;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import com.condominio.backend.core.enums.Classificacao;
import com.condominio.backend.core.enums.EstadoCivil;
import com.condominio.backend.core.enums.Sexo;
import com.condominio.backend.core.enums.Situacao;
import com.condominio.backend.entity.PessoaEntity;

public class PessoaEntityFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(PessoaEntity.class).addTemplate("valid1", new Rule() {
			{
				add("id", new Long(1));
				add("nome", "Pessoa Nome");
				add("dataNascimento", LocalDate.of(2020, 01, 01));
				add("cpf", "32132132112");
				add("rg", "12345678");
				add("estadoCivil", EstadoCivil.SOLTEIRO);
				add("sexo", Sexo.M);
				add("email", "teste@teste.com.br");
				add("situacao", Situacao.ATIVO);
				add("classificacao", Classificacao.PROPRIETARIO_MORADOR);
			}
		});

		Fixture.of(PessoaEntity.class).addTemplate("valid2", new Rule() {
			{
				add("id", new Long(3));
				add("nome", "Pessoa Nome 2");
				add("dataNascimento", LocalDate.of(2020, 10, 30));
				add("cpf", "321321321122");
				add("rg", "123456782");
				add("estadoCivil", EstadoCivil.CASADO);
				add("sexo", Sexo.F);
				add("email", "teste@teste.com.br2");
				add("situacao", Situacao.INATIVO);
				add("classificacao", Classificacao.FUNCIONARIO_CONDOMINIO);
			}
		});

		Fixture.of(PessoaEntity.class).addTemplate("valid3", new Rule() {
			{
				add("id", new Long(2));
				add("nome", "Pessoa Nome 3");
				add("dataNascimento", LocalDate.of(2015, 05, 22));
				add("cpf", "321321321123");
				add("rg", "123456783");
				add("estadoCivil", EstadoCivil.DIVORCIADO);
				add("sexo", Sexo.M);
				add("email", "teste@teste.com.br3");
				add("situacao", Situacao.ATIVO);
				add("classificacao", Classificacao.VISITANTE);
			}
		});

	}

}
