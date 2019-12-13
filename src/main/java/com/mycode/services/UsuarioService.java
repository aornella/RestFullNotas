package com.mycode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycode.entities.AuthUsuario;
import com.mycode.repositories.IAuthUsuarioRepository;
import com.mycode.repositories.IAuthUsuarioRolRepository;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService{

	@Autowired
	@Qualifier("usuarioRepository")
	private IAuthUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioRolRepository")
	private IAuthUsuarioRolRepository usuarioRolRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AuthUsuario u = usuarioRepository.findBynombreUsuario(username);
		List<String> roles = usuarioRolRepository.findByIdUsuario(u.getId());
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (String var : roles) {
			authorities.add( new SimpleGrantedAuthority(var) );
		}
		
		return new User(u.getNombreUsuario(),
				        u.getContrasena(), 
				        u.isEnabled(), 
				        u.isAccountNonExpired(), 
				        u.isCredentialsNonExpired(),
				        u.isAccountNonLocked(), authorities);
	}
	
}
