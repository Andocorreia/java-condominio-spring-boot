package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.LoginRequestAdapter;
import com.condominio.backend.request.LoginRequest;

import unitario.ApplicationUnitTests;

class LoginRequestAdapterTest extends ApplicationUnitTests {

	LoginRequestAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new LoginRequestAdapter();
	}

	@Test
	void dadoUmLoginRequestValidoQuandoPassarPeloAdapterEntaoUmUsernamePasswordAuthenticationTokenValidoDeveSerRetornado() {
		// Dado
		final LoginRequest request = Fixture.from(LoginRequest.class).gimme("valid");

		// Quando
		final UsernamePasswordAuthenticationToken token = adapter.convert(request);

		// Então
		assertEquals(request.getUsuario(), token.getName());
		assertEquals(request.getSenha(), token.getCredentials());
	}
}
