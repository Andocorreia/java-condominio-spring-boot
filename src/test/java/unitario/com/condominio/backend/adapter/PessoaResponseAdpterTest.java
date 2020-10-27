package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.PessoaResponseAdapter;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.response.PessoaResponse;

import unitario.ApplicationUnitTests;

class PessoaResponseAdpterTest extends ApplicationUnitTests{

	PessoaResponseAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new PessoaResponseAdapter();
	}

	@Test
	void dadoUmPessoaEntityValidoQuandoPassarPeloAdapterEntaoUmPessoaResponseValidoDeveSerRetornado() {
		// Dado
		final PessoaEntity entity = Fixture.from(PessoaEntity.class).gimme("valid1");

		// Quando
		final PessoaResponse response = adapter.convert(entity);

		// Então
		assertEquals(entity.getId(),response.getId());
		assertEquals(entity.getNome(),response.getNome());
		assertEquals(entity.getDataNascimento(),response.getDataNascimento());
		assertEquals(entity.getCpf(),response.getCpf());
		assertEquals(entity.getRg(),response.getRg());
		assertEquals(entity.getEstadoCivil(),response.getEstadoCivil());
		assertEquals(entity.getSexo(),response.getSexo());
		assertEquals(entity.getEmail(),response.getEmail());
		assertEquals(entity.getSituacao(),response.getSituacao());
		assertEquals(entity.getClassificacao(),response.getClassificacao());
	}

	@Test
	void dadoUmaListaDePessoaEntityValidoQuandoPassarPeloAdapterEntaoUmaListaDePessoaResponseValidoDeveSerRetornado() {
		// Dado
		final Collection<PessoaEntity> entityCollection = Fixture.from(PessoaEntity.class).gimme(3, "valid1", "valid2", "valid3");

		// Quando
		final Collection<PessoaResponse> responseCollection = adapter.convert(entityCollection);

		// Então
		assertEquals(3,responseCollection.size());
		for(int i = 0; i< responseCollection.size(); i ++) {
			final PessoaEntity entity = new ArrayList<>(entityCollection).get(i);
			final PessoaResponse response = new ArrayList<>(responseCollection).get(i);

			assertEquals(entity.getId(),response.getId());
			assertEquals(entity.getNome(),response.getNome());
			assertEquals(entity.getDataNascimento(),response.getDataNascimento());
			assertEquals(entity.getCpf(),response.getCpf());
			assertEquals(entity.getRg(),response.getRg());
			assertEquals(entity.getEstadoCivil(),response.getEstadoCivil());
			assertEquals(entity.getSexo(),response.getSexo());
			assertEquals(entity.getEmail(),response.getEmail());
			assertEquals(entity.getSituacao(),response.getSituacao());
			assertEquals(entity.getClassificacao(),response.getClassificacao());
		}
	}

}
