package unitario.com.condominio.backend.adapter;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.EnderecoResponseAdapter;
import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.response.EnderecoResponse;

import unitario.ApplicationUnitTests;

class EnderecoResponseAdapterTest extends ApplicationUnitTests {

	EnderecoResponseAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new EnderecoResponseAdapter();
	}

	@Test
	void dadoUmEnderecoEntityValidoQuandoPassarPeloAdapterEntaoUmEnderecoResponseValidoDeveSerRetornado() {
		// Dado
		final Collection<EnderecoEntity> enderecoEntity = Fixture.from(EnderecoEntity.class).gimme(3, "valid1", "valid2", "valid3");

		// Quando
		final Collection<EnderecoResponse> enderecoResponse = adapter.convert(enderecoEntity);

		// Então
		assertEquals(3, enderecoResponse.size());

		for(int i = 0; i < enderecoResponse.size(); i++) {
			final EnderecoResponse response = new ArrayList<>(enderecoResponse).get(i);
			final EnderecoEntity entity = new ArrayList<>(enderecoEntity).get(i);

			assertEquals(entity.getId(), response.getId());
			assertEquals(entity.getTipo(), response.getTipo());
			assertEquals(entity.getRua(), response.getRua());
			assertEquals(entity.getNumero(), response.getNumero());
			assertEquals(entity.getComplemento(), response.getComplemento());
			assertEquals(entity.getCep(), response.getCep());
			assertEquals(entity.getBairro(), response.getBairro());
			assertEquals(entity.getCidade(), response.getCidade());
			assertEquals(entity.getUf(), response.getUf());
			assertEquals(entity.getPais(), response.getPais());
		}
	}

	@Test
	void dadoUmEnderecoEntityVazioQuandoPassarPeloAdapterEntaoUmEnderecoResponseVazioDeveSerRetornado() {
		final Collection<EnderecoEntity> enderecoEntity = new ArrayList<>();

		// Quando
		final Collection<EnderecoResponse> enderecoResponse = adapter.convert(enderecoEntity);

		// Então
		assertEquals(0, enderecoResponse.size());

	}
}
