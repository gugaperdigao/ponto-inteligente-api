package com.gugaperdigao.inteligente.api.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gugaperdigao.inteligente.api.entity.Usuario;
import com.gugaperdigao.inteligente.api.security.JwtUserFactory;
import com.gugaperdigao.inteligente.api.service.UsuarioService;


@Component
public class JwtUserDetailsServiceImpl  implements UserDetailsService{

	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario =
				usuarioService.buscarPorEmail(username);
				if (usuario.isPresent()) {
//					String senha = PasswordUtils.gerarBCrypt("123456");
				return JwtUserFactory.create(usuario.get());
				}
				throw new UsernameNotFoundException("Email não encontrado.");
	}

}
