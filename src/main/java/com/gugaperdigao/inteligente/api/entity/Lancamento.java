package com.gugaperdigao.inteligente.api.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gugaperdigao.inteligente.api.enums.TipoEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lancamento", schema="public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data" , nullable = false)
	private Date data;
	
	
	
	@Column(name="descricao" ,nullable=false)
	private String descricao;
	
	
	@Column(name="localizacao" ,nullable=false)
	private String localizacao;
	
	
	@Column(name="data_criacao" , nullable = false)
	private Date dataCriacao;
	
	@Column(name="data_atualizacao" , nullable = false)
	private Date dataAtualizacao;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo" ,nullable=false)
	private TipoEnum tipo;
	
	
	@ManyToOne 
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	
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
