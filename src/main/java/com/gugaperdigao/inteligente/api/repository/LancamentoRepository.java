package com.gugaperdigao.inteligente.api.repository;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gugaperdigao.inteligente.api.entity.Lancamento;

@Transactional(readOnly = true)
//jpql
@NamedQueries({
		@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", query = "SELECT lanc FROM LANCAMENTO lanc where lanc.funcionario.id =:funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
	
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId , Pageable pageable);

}
