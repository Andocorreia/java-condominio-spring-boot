package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.PessoaRequestAdapter;
import com.condominio.backend.core.enums.Classificacao;
import com.condominio.backend.core.enums.EstadoCivil;
import com.condominio.backend.core.enums.Sexo;
import com.condominio.backend.core.enums.Situacao;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.request.PessoaRequest;

import unitario.ApplicationUnitTests;

public class PessoaRequestAdapterTest extends ApplicationUnitTests {

	PessoaRequestAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new PessoaRequestAdapter();
	}

	@Test
	void dadoUmPessoaRequestValidoQuandoPassarPeloAdapterEntaoUmPessoaEntityValidoDeveSerRetornado() {
		// Dado
		final PessoaRequest request = Fixture.from(PessoaRequest.class).gimme("valid");

		// Quando
		final PessoaEntity entity = adapter.convert(request);

		// Então
		assertNull(entity.getId());
		assertEquals(request.getNome(), entity.getNome());
		assertEquals(convertStringToData(request.getDataNascimento()), entity.getDataNascimento());
		assertEquals(request.getCpf(), entity.getCpf());
		assertEquals(request.getRg(), entity.getRg());
		assertEquals(EstadoCivil.valueOf(request.getEstadoCivil().toUpperCase()), entity.getEstadoCivil());
		assertEquals(Sexo.valueOf(request.getSexo()), entity.getSexo());
		assertEquals(request.getEmail(), entity.getEmail());
		assertEquals(Situacao.ATIVO, entity.getSituacao());
		assertEquals(Classificacao.valueOf(request.getClassificacao().toUpperCase()), entity.getClassificacao());
	}

	@Test
	void dadoUmPessoaRequestVaziaQuandoPassarPeloAdapterEntaoUmPessoaEntityVaziaDeveSerRetornado() {
		// Dado
		final PessoaRequest request = Fixture.from(PessoaRequest.class).gimme("valid");
		final PessoaEntity pessoaEntity = Fixture.from(PessoaEntity.class).gimme("valid1");

		// Quando
		final PessoaEntity entity = adapter.convert(pessoaEntity, request);

		// Então
		assertEquals(pessoaEntity.getId(), entity.getId());
		assertEquals(request.getNome(), entity.getNome());
		assertEquals(convertStringToData(request.getDataNascimento()), entity.getDataNascimento());
		assertEquals(request.getCpf(), entity.getCpf());
		assertEquals(request.getRg(), entity.getRg());
		assertEquals(EstadoCivil.valueOf(request.getEstadoCivil().toUpperCase()), entity.getEstadoCivil());
		assertEquals(Sexo.valueOf(request.getSexo()), entity.getSexo());
		assertEquals(request.getEmail(), entity.getEmail());
		assertEquals(Situacao.ATIVO, entity.getSituacao());
		assertEquals(Classificacao.valueOf(request.getClassificacao().toUpperCase()), entity.getClassificacao());

	}

	private LocalDate convertStringToData(final String dataNascimento) {
		final int ano = Integer.parseInt(dataNascimento.substring(0, 4));
		final int mes = Integer.parseInt(dataNascimento.substring(5, 7));
		final int dia = Integer.parseInt(dataNascimento.substring(8, 10));
		return LocalDate.of(ano, mes, dia);
	}

}
