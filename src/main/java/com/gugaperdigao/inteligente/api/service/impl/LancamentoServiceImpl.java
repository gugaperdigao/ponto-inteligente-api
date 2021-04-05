package com.gugaperdigao.inteligente.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gugaperdigao.inteligente.api.entity.Lancamento;
import com.gugaperdigao.inteligente.api.repository.LancamentoRepository;
import com.gugaperdigao.inteligente.api.service.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	
	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceimpl.class);
	
	@Autowired
	LancamentoRepository lancamentoRepository;

	@Override
	public List<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Busca lançamentos para um funcionario ID {}",funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscaPorId(Long id) {
		log.info("Busca lançamento por ID {}",id);
		return this.lancamentoRepository.findById(id);
	}

	@Override
	public Lancamento salvarLancamento(Lancamento lancamento) {
		log.info("Cadastrando lançamento {}",lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Deletando lancamento ID {}",id);
		this.lancamentoRepository.deleteById(id);
		
	}
	
	
	

}
