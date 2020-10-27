package com.condominio.backend.adapter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.condominio.backend.core.enums.PerfilUsuario;
import com.condominio.backend.entity.PerfilEntity;
import com.condominio.backend.entity.PessoaEntity;
import com.condominio.backend.entity.UsuarioEntity;
import com.condominio.backend.repository.PerfilRepository;
import com.condominio.backend.repository.PessoaRepository;
import com.condominio.backend.request.UsuarioRequest;

public class UsuarioRequestAdapter implements Adapter<UsuarioEntity, UsuarioRequest> {

	private final PessoaRepository pessoaRepository;
	private final PerfilRepository perfilRepository;

	public UsuarioRequestAdapter(final PessoaRepository pessoaRepository, final PerfilRepository perfilRepository) {
		this.pessoaRepository = pessoaRepository;
		this.perfilRepository = perfilRepository;
	}

	@Override
	public UsuarioEntity convert(final UsuarioRequest request) {

		final UsuarioEntity entity = new UsuarioEntity();
		final Optional<PessoaEntity> pessoaEntity = pessoaRepository.findById(request.getPessoaId());
		final List<PerfilEntity> perfis = getPerfis(request);

		if (pessoaEntity.isPresent() && perfis.size() > 0) {
			entity.setUsuario(request.getUsuario());
			entity.setSenha(request.getSenha());
			entity.setBloqueado(false);
			entity.setUltimaAlteracaoSenha(LocalDate.now());
			entity.setPerfis(perfis);
			entity.setPessoaId(pessoaEntity.get());
		}
		return entity;
	}

	private List<PerfilEntity> getPerfis(final UsuarioRequest request) {
		final List<PerfilEntity> perfis = new ArrayList<>();

		request.getPerfis().stream().forEach(nome -> {
			final Optional<PerfilEntity> perfil = perfilRepository.findByNome(PerfilUsuario.valueOf(nome.toUpperCase()));

			if (perfil.isPresent()) {
				perfis.add(perfil.get());
			}
		});
		return perfis;
	}
}
