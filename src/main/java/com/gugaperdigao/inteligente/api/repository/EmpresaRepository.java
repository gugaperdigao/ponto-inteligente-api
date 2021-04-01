package com.gugaperdigao.inteligente.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gugaperdigao.inteligente.api.entity.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{
	
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);
	
	

}
