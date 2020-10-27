package unitario.com.condominio.backend.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.configuration.security.AutenticacaoService;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.UsuarioRepository;

import unitario.ApplicationUnitTests;

class AutenticacaoServiceTest extends ApplicationUnitTests {

	UsuarioRepository usuarioRepository;
	UserDetails userDetails;

	@BeforeEach
	void setUp() {
		usuarioRepository = mock(UsuarioRepository.class);
		userDetails = mock(UserDetails.class);
	}

	@Test
	void dadoUsuarioValidoQuandoPassarPeloAutenticacaoServiceEntaoUmUserDetailsDeveSerRetornado() {
		// Dado
		final String usuario = "UsuarioTeste";
		final UsuarioEntity usuarioEntity = Fixture.from(UsuarioEntity.class).gimme("valid");
		when(usuarioRepository.findByUsuario(usuario)).thenReturn(Optional.of(usuarioEntity));

		// Quando
		final UserDetails userDetails = new AutenticacaoService(usuarioRepository).loadUserByUsername(usuario);

		// Então
		assertEquals(usuarioEntity.getUsername(), userDetails.getUsername());
		assertEquals(usuarioEntity.getPassword(), userDetails.getPassword());
	}

	@Test
	void dadoUsuarioInvalidoQuandoPassarPeloAutenticacaoServiceEntaoUmaExceptionDeveSerDisparada() {
		// Dado
		final String usuario = "UsuarioTeste";
		when(usuarioRepository.findByUsuario(usuario)).thenReturn(Optional.empty());

		// Quando
		final UsernameNotFoundException thrown = assertThrows(UsernameNotFoundException.class, () -> {
			new AutenticacaoService(usuarioRepository).loadUserByUsername(usuario);
		});

		// Então
		assertTrue(thrown.getMessage().contains("Dados inválidos!"));

	}

}
