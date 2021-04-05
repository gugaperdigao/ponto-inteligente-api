package com.gugaperdigao.inteligente.api.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class CadastroPJDto {
	
	@Setter @Getter
	private Long id;
	@Setter
	private String nome;
	@Setter
	private String email;
	@Setter
	private String senha;
	@Setter
	private String cpf;
	@Setter
	private String razaoSocial;
	@Setter
	private String cnpj;
	
	@NotEmpty(message = "O nome não pode ser vazio.")
	@Length(min=2,max = 200, message = "O nome deve conter entre 2 e 200 caracteres")
	public String getNome() {
		return nome;
	}
	
	@NotEmpty(message = "O e-mail não pode ser vazio.")
	@Length(min=5,max = 200, message = "O e-mail deve conter entre 5 e 200 caracteres")
	public String getEmail() {
		return email;
	}
	
	@NotEmpty(message = "A senha não pode ser vazia.")
	public String getSenha() {
		return senha;
	}
	
	@NotEmpty(message = "O CPF não pode ser vazio.")
	@CPF(message = "CPF inválido.")
	public String getCpf() {
		return cpf;
	}
	
	@NotEmpty(message = "O CPF não pode ser vazio.")
	@CNPJ(message = "CNPJ inmválido.")
	public String getCnpj() {
		return cnpj;
	}

	
	@NotEmpty(message = "A razão soccial não pode ser vazia.")
	@Length(min=2,max = 200, message = "O e-mail deve conter entre 5 e 200 caracteres")
	public String getRazaoSocial() {
		return razaoSocial;
	}

	@Override
	public String toString() {
		return "CadastroPjDto [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
	
	
	
}
