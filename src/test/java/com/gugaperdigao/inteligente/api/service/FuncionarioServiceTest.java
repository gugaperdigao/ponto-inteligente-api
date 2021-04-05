package com.gugaperdigao.inteligente.api.service;

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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gugaperdigao.inteligente.api.entity.Funcionario;
import com.gugaperdigao.inteligente.api.repository.FuncionarioRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class FuncionarioServiceTest {
	
	@MockBean
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@BeforeEach
	public void setUp() {
		
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(new Funcionario()));
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
	}
	
	
	@Test
	public void testSalvarFuncionario() {
		
		Funcionario funcionario = this.funcionarioService.cadastrarFuncionario(new Funcionario());
		Assertions.assertNotNull(funcionario);
		
	}

	@Test
	public void testBuscaFuncionarioPorId() {
		
		Optional<Funcionario> funcionario = this.funcionarioService.buscaPorId(1L);
		Assertions.assertTrue(funcionario.isPresent());
		
	}

	
	@Test
	public void testBuscaFuncionarioPorEmail() {
		
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail("perdigao@mcptecnologia.com");
		Assertions.assertTrue(funcionario.isPresent());
		
	}
	
	@Test
	public void testBuscaFuncionarioPorCpf() {
		
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf("23456677888");
		Assertions.assertTrue(funcionario.isPresent());
		
	}
	
	

}
