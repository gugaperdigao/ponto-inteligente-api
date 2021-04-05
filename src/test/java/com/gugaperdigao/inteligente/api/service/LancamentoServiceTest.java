package com.gugaperdigao.inteligente.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gugaperdigao.inteligente.api.entity.Lancamento;
import com.gugaperdigao.inteligente.api.repository.LancamentoRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class LancamentoServiceTest {

	
	@MockBean
	LancamentoRepository lancamentoRepository;
	
	@Autowired
	LancamentoService lancamentoService;
	
	@BeforeEach
	public void setUp() {
		
		BDDMockito
				.given(this.lancamentoRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
				.willReturn(new ArrayList<Lancamento>());
		BDDMockito.given(this.lancamentoRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Lancamento()));
		BDDMockito.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());
		
		
		
		
	}
	
	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		
		List<Lancamento> lancamento = this.lancamentoService.buscarPorFuncionarioId(1L, PageRequest.of(0, 10));
		Assertions.assertNotNull(lancamento);
	}
	
	
	@Test
	public void testBuscarPorId() {
		Optional<Lancamento> lancamento = this.lancamentoService.buscaPorId(1L);
		
	}
	
	@Test
	public void testSalvarLancamento() {
		
		Lancamento lancamento = this.lancamentoService.salvarLancamento(new Lancamento());
		Assertions.assertNotNull(lancamento);
		
	}
	
	
}
