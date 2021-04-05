package com.gugaperdigao.inteligente.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;

import com.gugaperdigao.inteligente.api.entity.Lancamento;

public interface LancamentoService {
	
	
	/**
	 * Busca lista de lançamentos por funcionario
	 * @param funcionarioId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	List<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	
	/**
	 * Retorna lancamento por ID
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento> buscaPorId(Long id);
	
	
	
	/**
	 * Cadastra lançamento no banco de dados
	 * @param lancamento
	 * @return lancamento
	 */
	Lancamento salvarLancamento(Lancamento lancamento);
	
	
	/**
	 * Remove lançamento do banco de dados
	 * @param id
	 */
	
	void remover(Long id);
	

}
