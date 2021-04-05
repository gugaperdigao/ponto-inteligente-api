package com.gugaperdigao.inteligente.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gugaperdigao.inteligente.api.entity.Empresa;
import com.gugaperdigao.inteligente.api.repository.EmpresaRepository;
import com.gugaperdigao.inteligente.api.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	@Override
	public Optional<Empresa> buscarEmpresaPorCnpj(String cnpj) {
		
		log.info("Buscando uma empresa para o CNPJ {}",cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa cadastrarEmpresa(Empresa empresa) {
		log.info("Salvando empresa {}",empresa);
		return empresaRepository.save(empresa);
	}

}
