package unitario.com.condominio.backend.adapter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

import com.condominio.backend.adapter.UsuarioRequestAdapter;
import com.condominio.backend.core.enums.PerfilUsuario;
import com.condominio.backend.entity.PerfilEntity;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.PerfilRepository;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.request.UsuarioRequest;

import unitario.ApplicationUnitTests;

class UsuarioRequestAdapterTest extends ApplicationUnitTests {

	PessoaRepository pessoaRepository;
	PerfilRepository perfilRepository;
	UsuarioRequestAdapter adapter;

	@BeforeEach
	void setUp() {
		pessoaRepository = mock(PessoaRepository.class);
		perfilRepository = mock(PerfilRepository.class);
		adapter = new UsuarioRequestAdapter(pessoaRepository, perfilRepository);
	}

	@Test
	void dadoUsuarioRequestValidoQuandoPassarPeloAdapterEntaoUmUsuarioEntityValidoDeveSerRetornado() {
		// Dado
		final UsuarioRequest request = Fixture.from(UsuarioRequest.class).gimme("valid");
		final PessoaEntity pessoaEntity = Fixture.from(PessoaEntity.class).gimme("valid1");
		final PerfilEntity perfilEntity1 = Fixture.from(PerfilEntity.class).gimme("valid1");
		final PerfilEntity perfilEntity2 = Fixture.from(PerfilEntity.class).gimme("valid2");

		final ArrayList<String> perfisRequest = new ArrayList<>(request.getPerfis());
		when(pessoaRepository.findById(request.getPessoaId())).thenReturn(Optional.of(pessoaEntity));
		when(perfilRepository.findByNome(PerfilUsuario.valueOf(perfisRequest.get(0).toUpperCase()))).thenReturn(Optional.of(perfilEntity1));
		when(perfilRepository.findByNome(PerfilUsuario.valueOf(perfisRequest.get(1).toUpperCase()))).thenReturn(Optional.of(perfilEntity2));

		// Quando
		final UsuarioEntity entity = adapter.convert(request);

		// Então
		final ArrayList<PerfilEntity> perfilEntity = new ArrayList<>(entity.getPerfis());

		assertFalse(entity.getBloqueado());
		assertNotNull(entity.getSenha());
		assertEquals(request.getUsuario() ,entity.getUsuario());
		assertEquals(LocalDate.now() ,entity.getUltimaAlteracaoSenha());
		assertEquals(request.getPessoaId() ,entity.getPessoaId().getId());
		assertEquals(perfisRequest.size() ,entity.getPerfis().size());

		for(int i = 0; i < perfilEntity.size(); i++) {
			assertEquals(PerfilUsuario.valueOf(perfisRequest.get(i).toUpperCase()), perfilEntity.get(i).getNome());
		}
	}

	@Test
	void dadoUsuarioRequestSemPerfilQuandoPassarPeloAdapterEntaoUsuarioEntityVazioDeveSerRetornado() {
		// Dado
		final UsuarioRequest request = Fixture.from(UsuarioRequest.class).gimme("valid");
		final PessoaEntity pessoaEntity = Fixture.from(PessoaEntity.class).gimme("valid1");

		final ArrayList<String> perfisRequest = new ArrayList<>(request.getPerfis());
		when(pessoaRepository.findById(request.getPessoaId())).thenReturn(Optional.of(pessoaEntity));
		when(perfilRepository.findByNome(PerfilUsuario.valueOf(perfisRequest.get(0).toUpperCase()))).thenReturn(Optional.empty());
		when(perfilRepository.findByNome(PerfilUsuario.valueOf(perfisRequest.get(1).toUpperCase()))).thenReturn(Optional.empty());

		// Quando
		final UsuarioEntity entity = adapter.convert(request);

		// Então
		assertNull(entity.getBloqueado());
		assertNull(entity.getSenha());
		assertNull(entity.getUsuario());
		assertNull(entity.getUltimaAlteracaoSenha());
		assertNull(entity.getPessoaId());
		assertEquals(0, entity.getPerfis().size());
	}

	@Test
	void dadoUsuarioRequestSemPessoaQuandoPassarPeloAdapterEntaoUsuarioEntityVazioDeveSerRetornado() {
		// Dado
		final UsuarioRequest request = Fixture.from(UsuarioRequest.class).gimme("valid");
		final PerfilEntity perfilEntity1 = Fixture.from(PerfilEntity.class).gimme("valid1");
		final PerfilEntity perfilEntity2 = Fixture.from(PerfilEntity.class).gimme("valid2");

		final ArrayList<String> perfisRequest = new ArrayList<>(request.getPerfis());
		when(pessoaRepository.findById(request.getPessoaId())).thenReturn(Optional.empty());
		when(perfilRepository.findByNome(PerfilUsuario.valueOf(perfisRequest.get(0).toUpperCase()))).thenReturn(Optional.of(perfilEntity1));
		when(perfilRepository.findByNome(PerfilUsuario.valueOf(perfisRequest.get(1).toUpperCase()))).thenReturn(Optional.of(perfilEntity2));

		// Quando
		final UsuarioEntity entity = adapter.convert(request);

		// Então
		assertNull(entity.getBloqueado());
		assertNull(entity.getSenha());
		assertNull(entity.getUsuario());
		assertNull(entity.getUltimaAlteracaoSenha());
		assertNull(entity.getPessoaId());
		assertEquals(0, entity.getPerfis().size());
	}
}
