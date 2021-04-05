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

import com.gugaperdigao.inteligente.api.entity.Empresa;
import com.gugaperdigao.inteligente.api.repository.EmpresaRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class EmpresaServiceTest {
	
	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	
	private final String CNPJ = "57769761000120";
	
	@BeforeEach
	public void setUp() throws Exception {
		
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
		
		
	}
	
	
	@Test
	public void testBuscarEmpresaPorCnpj() {
		
		Optional<Empresa> empresa = this.empresaService.buscarEmpresaPorCnpj(CNPJ);
		Assertions.assertTrue(empresa.isPresent());
		
	}
	
	@Test
	public void testSalvarEmpresa() {
		
		Empresa empresa = this.empresaService.cadastrarEmpresa(new Empresa());
		Assertions.assertNotNull(empresa);
		
	}
	

}
