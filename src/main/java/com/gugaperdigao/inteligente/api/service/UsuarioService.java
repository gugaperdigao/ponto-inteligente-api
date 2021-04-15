package com.gugaperdigao.inteligente.api.service;

import java.util.Optional;

import com.gugaperdigao.inteligente.api.entity.Usuario;

public interface UsuarioService {
	
	
	/**
	* Busca e retorna um usuário dado um email.
	*
	* @param email
	* @return Optional<Usuario>
	*/
	Optional<Usuario> buscarPorEmail(String email);
	

}
