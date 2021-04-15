package com.gugaperdigao.inteligente.api.repository;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gugaperdigao.inteligente.api.entity.Empresa;
import com.gugaperdigao.inteligente.api.entity.Funcionario;
import com.gugaperdigao.inteligente.api.entity.Lancamento;
import com.gugaperdigao.inteligente.api.enums.PerfilEnum;
import com.gugaperdigao.inteligente.api.enums.TipoEnum;
import com.gugaperdigao.inteligente.api.utils.PasswordUtils;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
	
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;

	@BeforeEach
	public  void setUp() throws Exception {
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
		this.lancamentoRepository.save(obterDadosLancamentos(funcionario));
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.empresaRepository.deleteAll();
	}

	@Test
	public void testBuscarLancamentosPorFuncionarioId() {
		
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		Assertions.assertEquals(2, lancamentos.size());
	}
	
	@Test
	public void testBuscarLancamentosPorFuncionarioIdPaginado() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, PageRequest.of(0,10));
		Assertions.assertEquals(2, lancamentos.size());
		
	}
	
	private Lancamento obterDadosLancamentos(Funcionario funcionario) {
		Lancamento lancameto = Lancamento.builder().data(new Date()).tipo(TipoEnum.INICIO_ALMOCO).funcionario(funcionario).descricao("Lançamento de teste").localizacao("BH").build();
		return lancameto;
	}

	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException {
		Funcionario funcionario = Funcionario.builder().nome("Fulano de Tal").perfil(PerfilEnum.ROLE_USUARIO)
				.senha(PasswordUtils.gerarBCrypt("1234")).cpf("04106360616").email("email@email.com").empresa(empresa)
				.qtdHorasAlmoco(Float.valueOf("2.0")).qtdHorasTrabalhoDia(Float.valueOf("8.0"))
				.valorHora(new BigDecimal("70.0")).build();		
		return funcionario;
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = Empresa.builder().razaoSocial("Empresa de exemplo").cnpj("51463645000100").build();
		return empresa;
	}
	

}
