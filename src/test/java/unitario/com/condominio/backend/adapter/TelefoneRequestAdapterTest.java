package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.TelefoneRequestAdapter;
import com.condominio.backend.core.enums.TipoTelefone;
import com.condominio.backend.entity.TelefoneEntity;
import com.condominio.backend.request.PessoaRequest;
import com.condominio.backend.request.PessoaRequest.Telefone;

import unitario.ApplicationUnitTests;

class TelefoneRequestAdapterTest extends ApplicationUnitTests {

	TelefoneRequestAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new TelefoneRequestAdapter();
	}

	@Test
	void dadoUmPessoaRequestValidoQuandoPassarPeloAdapterEntaoUmPessoaEntityValidoDeveSerRetornado() {
		// Dado
		final PessoaRequest pessoaRequest = Fixture.from(PessoaRequest.class).gimme("valid");

		// Quando
		final List<TelefoneEntity> pessoaEntity = adapter.convert(pessoaRequest);

		// Então
		assertEquals(3, pessoaEntity.size());

		for(int i = 0; i < pessoaEntity.size(); i++) {
			final Telefone request = pessoaRequest.getTelefones().get(i);
			final TelefoneEntity entity = pessoaEntity.get(i);

			assertEquals(request.getNumero(), entity.getNumero());
			assertEquals(TipoTelefone.valueOf(request.getTipo().toUpperCase()), entity.getTipo());
			assertEquals(request.getComplemento(), entity.getComplemento());
		}
	}

}
