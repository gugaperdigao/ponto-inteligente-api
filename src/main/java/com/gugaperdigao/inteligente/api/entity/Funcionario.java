package com.gugaperdigao.inteligente.api.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gugaperdigao.inteligente.api.enums.PerfilEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "funcionario", schema="public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "funcionario_sequence")
	@SequenceGenerator(name="funcionario_sequence", sequenceName = "seq_funcionario" , allocationSize = 1)
	private Long id;
	
	@Column(name="nome" ,nullable=false)
	private String nome;
	
	
	@Column(name="email" ,nullable=false)
	private String email;
	
	@Column(name="senha" ,nullable=false)
	private String senha;

	@Column(name="cpf" ,nullable=false)
	private String cpf;

	@Column(name="valor_hora" ,nullable=false)
	private BigDecimal valorHora;
	
	@Column(name="qtd_horas_trabalho_dia" ,nullable=false)
	private Float qtdHorasTrabalhoDia;
	
	
	@Column(name="qtd_horas_almoco" ,nullable=false)
	private Float qtdHorasAlmoco;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="perfil" ,nullable=false)
	private PerfilEnum  perfil;
	
	@Column(name="data_criacao" , nullable = false)
	private Date dataCriacao;
	
	@Column(name="data_atualizacao" , nullable = false)
	private Date dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;
	
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);
	}
	
	@PrePersist
	public void prePersist() {
		
		final Date atual = new Date(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);
		dataCriacao = atual;
		dataAtualizacao = atual;
		
	}
	
	

}
