package unitario.com.condominio.backend.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.TelefoneResponseAdapter;
import com.condominio.backend.entity.TelefoneEntity;
import com.condominio.backend.response.TelefoneResponse;

import unitario.ApplicationUnitTests;

class TelefoneResponseAdapterTest extends ApplicationUnitTests {

	TelefoneResponseAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new TelefoneResponseAdapter();
	}

	@Test
	void dadoUmaListaDeTelefoneEntityValidaQuandoPassarPeloAdapterEntaoUmaListaDeTelefoneResponseValidaDeveSerRetornada() {

		// Dado
		final Collection<TelefoneEntity> collectionEntity = Fixture.from(TelefoneEntity.class).gimme(3, "valid1", "valid2", "valid3");

		// Quando
		final Collection<TelefoneResponse> collectionResponse = adapter.convert(collectionEntity);

		// Então

		assertEquals(3, collectionResponse.size());

		for( int i = 0; i < collectionResponse.size(); i ++) {
			final TelefoneEntity entity = new ArrayList<>(collectionEntity).get(i);
			final TelefoneResponse response = new ArrayList<>(collectionResponse).get(i);

			assertEquals(entity.getId(), response.getId());
			assertEquals(entity.getNumero(), response.getNumero());
			assertEquals(entity.getComplemento(), response.getComplemento());
			assertEquals(entity.getTipo(), response.getTipo());
		}

	}
}
