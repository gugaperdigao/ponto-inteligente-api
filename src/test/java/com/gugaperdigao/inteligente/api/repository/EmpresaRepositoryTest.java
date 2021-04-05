package com.gugaperdigao.inteligente.api.repository;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gugaperdigao.inteligente.api.entity.Empresa;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class EmpresaRepositoryTest {

 @Autowired	
 private EmpresaRepository empresaRepository;
 
 private static final String CNPJ = "57769761000120";
 
 @BeforeEach
 public void seTup() throws Exception{
	 
	 Empresa empresa = Empresa.builder().razaoSocial("Empresa de Exemplo").cnpj(CNPJ).build();
	 empresaRepository.save(empresa);
 }
 
 @AfterEach
 public void testBuscarEmpresaPorCnpj() {
	 
	 Empresa empresa = empresaRepository.findByCnpj(CNPJ);
	 Assertions.assertEquals(empresa.getCnpj(), CNPJ);
	 
 }
 

}
