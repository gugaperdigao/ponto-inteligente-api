package com.gugaperdigao.inteligente.api.service;

import java.util.Optional;

import com.gugaperdigao.inteligente.api.entity.Funcionario;


public interface FuncionarioService {
	
	
	/**
	 * Cadastra um novo funcionario na base de dados
	 * @param funcionario
	 * @return
	 */
	Funcionario cadastrarFuncionario(Funcionario funcionario);
	
	/**
	 * Retorna um funcionario dado um cpf
	 * @param cpf
	 * @return
	 */
	Optional <Funcionario> buscarPorCpf(String cpf);
	
	
	/**
	 * Retorna um funcionario dado um email
	 * @param email
	 * @return
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	
	/**
	 * Retorna um funcionario dado um ID
	 * @param id
	 * @return
	 */
	Optional<Funcionario> buscaPorId(Long id);
	

}
