package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.EnderecoRequestAdapter;
import com.condominio.backend.core.enums.TipoEndereco;
import com.condominio.backend.entity.EnderecoEntity;
import com.condominio.backend.request.PessoaRequest;
import com.condominio.backend.request.PessoaRequest.Endereco;

import unitario.ApplicationUnitTests;

class EnderecoRequestAdapterTest extends ApplicationUnitTests {

	EnderecoRequestAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new EnderecoRequestAdapter();
	}

	@Test
	void dadoUmEnderecoRequestValidoQuandoPassarPeloAdapterEntaoUmEnderecoEntityValidoDeveSerRetornado() {
		// Dado
		final PessoaRequest request = Fixture.from(PessoaRequest.class).gimme("valid");

		// Quando
		final List<EnderecoEntity> entity = adapter.convert(request );

		// Então
		assertEquals(3, entity.size());

		for(int i = 0; i < entity.size(); i++ ) {
			final Endereco enderecoRequest = request.getEnderecos().get(i);
			assertEquals(TipoEndereco.valueOf(enderecoRequest.getTipo().toUpperCase()), entity.get(i).getTipo());
			assertEquals(enderecoRequest.getRua(), entity.get(i).getRua());
			assertEquals(enderecoRequest.getNumero(), entity.get(i).getNumero());
			assertEquals(enderecoRequest.getComplemento(), entity.get(i).getComplemento());
			assertEquals(enderecoRequest.getCep(), entity.get(i).getCep());
			assertEquals(enderecoRequest.getBairro(), entity.get(i).getBairro());
			assertEquals(enderecoRequest.getCidade(), entity.get(i).getCidade());
			assertEquals(enderecoRequest.getUf(), entity.get(i).getUf());
			assertEquals(enderecoRequest.getPais(), entity.get(i).getPais());
		}

	}

	@Test
	void dadoUmEnderecoRequestVazioQuandoPassarPeloAdapterEntaoUmEnderecoEntityVazioDeveSerRetornado() {
		// Dado
		final PessoaRequest request = new PessoaRequest();

		// Quando
		final List<EnderecoEntity> entity = adapter.convert(request );

		// Então
		assertEquals(0, entity.size());

	}

}
