package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.condominio.backend.adapter.LoginResponseAdapter;
import com.condominio.backend.response.LoginResponse;

import unitario.ApplicationUnitTests;

public class LoginResponseAdapterTest extends ApplicationUnitTests {

	LoginResponseAdapter adapter;

	@BeforeEach
	void init() {
		adapter = new LoginResponseAdapter();
	}

	@Test
	void dadoUmTokenValidoQuandoPassarPeloAdapterEntaoUmLoginResponseValidoDeveSerRetornado() {
		// Dado
		final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDMzMDE3NTAsImdpZGVzIjpbIlBGR1NFRzAyIiwiQ0lOVjAwMDEiLCJDSU5WMDEiLCJDSU5WMDMiLCJDSU5WMDIiLCJDSU5WMDUiLCJDSU5WMDQiLCJDSU5WMzQiXX0.pAiQVBlM1HpsCHeNmixepdPeKd12EYdNQ72X8dkA4OA";

		// Quando
		final LoginResponse response = adapter.convert(token);

		// Então
		assertEquals(token, response.getToken());
	}

}
