package com.mycode.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.config.AuthenticationRequest;
import com.mycode.config.AuthenticationResponse;
import com.mycode.config.JwtUtil;
import com.mycode.services.UsuarioService;


@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	@Qualifier("jwtTokenUtil")
	private JwtUtil jwtTokenUtil;
	
	@Autowired 
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
	throws Exception {
		try {
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
			
		} catch (BadCredentialsException e) {
			
			throw new Exception("Nombre de usuario o contraseña incorrecta", e);
		}
		
		final UserDetails userDetails = usuarioService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
