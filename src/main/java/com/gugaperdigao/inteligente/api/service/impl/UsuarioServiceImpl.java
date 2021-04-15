package com.gugaperdigao.inteligente.api.service.impl;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gugaperdigao.inteligente.api.entity.Usuario;
import com.gugaperdigao.inteligente.api.repository.UsuarioRepository;
import com.gugaperdigao.inteligente.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Optional<Usuario> buscarPorEmail(String email) {
	return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
	
	

}
