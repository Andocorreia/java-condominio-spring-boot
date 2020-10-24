package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.ApartamentoPessoaRequestAdapter;
import com.condominio.backend.entity.ApartamentoPessoaEntity;
import com.condominio.backend.request.PessoaRequest;

import unitario.ApplicationUnitTests;

class ApartamentoPessoaRequestAdapterTest extends ApplicationUnitTests {
	ApartamentoPessoaRequestAdapter adapter;

	@BeforeEach
	void setUp() {
		adapter = new ApartamentoPessoaRequestAdapter();
	}

	@Test
	void dadoUmaPessoaRequestValidaQuandoPassarPeloAdapterEntaoUmApartamentoPessoaEntityValidoDeveSerRetornado() {
		// Dado
		final PessoaRequest pessoaRequest = Fixture.from(PessoaRequest.class).gimme("valid");

		// Quando
		final List<ApartamentoPessoaEntity> entity = adapter.convert(pessoaRequest);

		// Então
		assertEquals(3, entity.size());
		assertNull(entity.get(0).getPessoaId());
		assertEquals(new Long(1), entity.get(0).getApartamentoId());

		assertNull(entity.get(1).getPessoaId());
		assertEquals(new Long(2), entity.get(1).getApartamentoId());

		assertNull(entity.get(2).getPessoaId());
		assertEquals(new Long(3), entity.get(2).getApartamentoId());

	}

	@Test
	void dadoUmaPessoaRequestVaziaQuandoPassarPeloAdapterEntaoUmApartamentoPessoaEntityVaziaDeveSerRetornado() {
		//Dado
		final PessoaRequest pessoaRequest = new PessoaRequest();

		//Quando
		final List<ApartamentoPessoaEntity> entity = adapter.convert(pessoaRequest);

		//Então
		assertEquals(0, entity.size());

	}
}
