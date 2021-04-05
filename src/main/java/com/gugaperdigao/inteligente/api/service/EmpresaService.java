package com.gugaperdigao.inteligente.api.service;

import java.util.Optional;

import com.gugaperdigao.inteligente.api.entity.Empresa;

public interface EmpresaService {
	
	
	/**
	 * Dado um cnpj, retorna uma empresa cadastrada
	 * 
	 * @param cnpj
	 * @return
	 */
	 Optional<Empresa> buscarEmpresaPorCnpj(String cnpj);
	
	/**
	 * Cadastra uma nova empresa no banco de dados
	 * 
	 * @param empresa
	 * @return
	 */
	Empresa cadastrarEmpresa (Empresa empresa);
	

}
