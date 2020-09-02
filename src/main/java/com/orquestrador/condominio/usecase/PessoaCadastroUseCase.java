package com.orquestrador.condominio.usecase;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orquestrador.condominio.adapter.ApartamentoPessoaAdapter;
import com.orquestrador.condominio.adapter.EnderecoAdapter;
import com.orquestrador.condominio.adapter.PessoaAdapter;
import com.orquestrador.condominio.adapter.TelefoneAdapter;
import com.orquestrador.condominio.entity.ApartamentoPessoaEntity;
import com.orquestrador.condominio.entity.EnderecoEntity;
import com.orquestrador.condominio.entity.PessoaEntity;
import com.orquestrador.condominio.entity.TelefoneEntity;
import com.orquestrador.condominio.repository.ApartamentoPessoaRepository;
import com.orquestrador.condominio.repository.EnderecoRepository;
import com.orquestrador.condominio.repository.PessoaRepository;
import com.orquestrador.condominio.repository.TelefoneRepository;
import com.orquestrador.condominio.request.CadastroPessoaRequest;

@Service
public class PessoaCadastroUseCase {

	@Autowired
	ApartamentoPessoaRepository apartamentoPessoarepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	TelefoneRepository telefoneRepository;

	@Transactional
	public void execute(final CadastroPessoaRequest request) {

		final PessoaEntity pessoaEntity = new PessoaAdapter().convert(request);
		final List<ApartamentoPessoaEntity> apartamentoPessoaEntity = new ApartamentoPessoaAdapter().convert(request);
		final List<TelefoneEntity> telefoneEntity = new TelefoneAdapter().convert(request);
		final List<EnderecoEntity> enderecoEntity = new EnderecoAdapter().convert(request);

		pessoaRepository.save(pessoaEntity);

		apartamentoPessoaEntity.forEach(apartamento -> apartamento.setPessoaId(pessoaEntity.getId()));
		apartamentoPessoarepository.saveAll(apartamentoPessoaEntity);

		telefoneEntity.forEach(telefone -> telefone.setPessoaId(pessoaEntity));
		telefoneRepository.saveAll(telefoneEntity);

		enderecoEntity.forEach(endereco -> endereco.setPessoaId(pessoaEntity));
		enderecoRepository.saveAll(enderecoEntity);

	}
}
