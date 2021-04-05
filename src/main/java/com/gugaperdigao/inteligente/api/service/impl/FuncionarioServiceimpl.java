package com.gugaperdigao.inteligente.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gugaperdigao.inteligente.api.entity.Funcionario;
import com.gugaperdigao.inteligente.api.repository.FuncionarioRepository;
import com.gugaperdigao.inteligente.api.service.FuncionarioService;

@Service
public class FuncionarioServiceimpl implements FuncionarioService {
	
	private static final Logger log = LoggerFactory.getLogger(Funcionario.class);
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		log.info("Salvando funcionario {}",funcionario);
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando funcionario por cpf {}",cpf);
		return Optional.ofNullable(funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando funcionario por email {}",email);
		return Optional.ofNullable(funcionarioRepository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscaPorId(Long id) {
		log.info("Buscando funcionario por ID {}",id);
		return funcionarioRepository.findById(id);
	}

}
