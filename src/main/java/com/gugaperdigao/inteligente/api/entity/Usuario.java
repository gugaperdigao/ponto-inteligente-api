package com.gugaperdigao.inteligente.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.gugaperdigao.inteligente.api.enums.PerfilEnum;

import lombok.Data;

@Entity
@Data
@Table(name="usuario")
public class Usuario {
	
	private static final long serialVersionUID = 306411570471828345L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
	@SequenceGenerator(name="usuario_sequence",sequenceName = "seq_usuario", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false, name= "email")
	private String email;
	
	
	@Column(nullable = false, name= "senha")
	private String senha;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="perfil", nullable = false)
	private PerfilEnum perfil;


}
