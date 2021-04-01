package com.gugaperdigao.inteligente.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gugaperdigao.inteligente.api.entity.Funcionario;


@Transactional(readOnly=true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	Funcionario findByCpf(String cpf);
	Funcionario findByEmail(String cpf);
	Funcionario findByCpfOrEmail(String cpf,String email);
}
