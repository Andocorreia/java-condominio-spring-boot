package unitario.com.condominio.backend.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.ApartamentoAdapter;
import com.condominio.backend.core.enums.Bloco;
import com.condominio.backend.entity.ApartamentoEntity;
import com.condominio.backend.response.ApartamentoResponse;

import unitario.ApplicationUnitTests;

class ApartamentoAdapterTest extends ApplicationUnitTests {
	ApartamentoAdapter adapter;

	@BeforeEach
	void setUp() {
		adapter = new ApartamentoAdapter();
	}

	@Test
	void dadoApartamentosEntityValidosQuandoPassarPeloAdapterRetornaResponseValidaOrdenadaDeveSerRetornada() {
		// Dado
		final Collection<ApartamentoEntity> entityArray = Fixture.from(ApartamentoEntity.class).gimme(5, "valid1", "valid2", "valid3", "valid4", "valid5");

		// Quando
		final ArrayList<ApartamentoResponse> response = (ArrayList<ApartamentoResponse>) adapter.convert(entityArray);

		// Então
		assertEquals(5, response.size());
		assertEquals(Bloco.AVANT, response.get(0).getBloco());
		assertEquals(new Integer(11), response.get(0).getApartamento());
		assertEquals(Bloco.AVANT, response.get(1).getBloco());
		assertEquals(new Integer(192), response.get(1).getApartamento());
		assertEquals(Bloco.MODERN, response.get(2).getBloco());
		assertEquals(new Integer(1), response.get(2).getApartamento());
		assertEquals(Bloco.MODERN, response.get(3).getBloco());
		assertEquals(new Integer(131), response.get(3).getApartamento());
		assertEquals(Bloco.MODERN, response.get(4).getBloco());
		assertEquals(new Integer(192), response.get(4).getApartamento());
	}

	@Test
	void dadoUmaListaDeApartamentosEntityVaziaQuandoPassarPeloAdapterRetornaUmaListaDeApartamentosResponseVaziaDeveSerRetornada() {
		// Dado
		final Collection<ApartamentoEntity> entityArray = new ArrayList<>();

		// Quando
		final ArrayList<ApartamentoResponse> response = (ArrayList<ApartamentoResponse>) adapter.convert(entityArray);

		// Então
		assertEquals(0, response.size());

	}

}
