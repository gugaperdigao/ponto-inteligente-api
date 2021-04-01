package com.gugaperdigao.inteligente.api.entity;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Table(name="empresa", schema = "public")
@Data
public class Empresa {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="razao_social" ,nullable=false)
	private String razaoSocial;
	
	@Column(name="cnpj" , nullable = false)
	private String cnpj;
	
	@Column(name="data_criacao" , nullable = false)
	private Date dataCriacao;
	
	@Column(name="data_atualizacao" , nullable = false)
	private Date dataAtualizacao;
	
	@OneToMany(mappedBy = "empresa" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios;
	
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
