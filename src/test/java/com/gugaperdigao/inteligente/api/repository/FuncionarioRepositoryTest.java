package com.gugaperdigao.inteligente.api.repository;




import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gugaperdigao.inteligente.api.entity.Empresa;
import com.gugaperdigao.inteligente.api.entity.Funcionario;
import com.gugaperdigao.inteligente.api.enums.PerfilEnum;
import com.gugaperdigao.inteligente.api.utils.PasswordUtils;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	private static final String EMAIL = "perdigao!mcptecnologia.com";
	private static final String CPF = "31854220071";
	
	
	@BeforeEach
	public void setUp() throws Exception {
		
		Empresa empresa = empresaRepository.save(obterDadosEmpresa());
		Funcionario funcionario = obterDadosFuncionario(empresa);
		funcionarioRepository.save(funcionario);
	}
	
	@AfterEach
	public void testDown() {
		
		funcionarioRepository.deleteAll();
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
		
		Funcionario funcionario = funcionarioRepository.findByEmail(EMAIL);
		Assertions.assertTrue(funcionario.getEmail().equals(EMAIL));
	}
	
	@Test
	public void testBuscarFuncionarioPorCpf() {
		
		Funcionario funcionario = funcionarioRepository.findByCpf(CPF);
		Assertions.assertTrue(funcionario.getCpf().equals(CPF));
	}
	
	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "email@invalido.com");
		Assertions.assertNotNull(funcionario);
	}

	
	@Test
	public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("12345678901", EMAIL);
//		Assert.notNull(funcionario);
		Assertions.assertNotNull(funcionario);
	}
	
	
	
	
	private Empresa obterDadosEmpresa() {
		Empresa empresa = Empresa.builder().razaoSocial("Empresa de exemplo").cnpj("51463645000100").build();
		return empresa;
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException  {
		
		Funcionario funcionario = Funcionario.builder().nome("Fulano de Tal").perfil(PerfilEnum.ROLE_USUARIO)
				.senha(PasswordUtils.gerarBCrypt("1234")).cpf(CPF).email(EMAIL).empresa(empresa)
				.qtdHorasAlmoco(Float.valueOf("2.0")).qtdHorasTrabalhoDia(Float.valueOf("8.0"))
				.valorHora(new BigDecimal("70.0")).build();
		return funcionario;
		
	}
	
	
	

}
