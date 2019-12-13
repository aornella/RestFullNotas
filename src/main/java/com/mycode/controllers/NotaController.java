package com.mycode.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.entities.Nota;
import com.mycode.services.NotaService;

@RestController
@RequestMapping("/v1/notas")
public class NotaController {
	
	
	@Autowired
	@Qualifier("notaService")
	private NotaService notaService;
	
	@PostMapping("/create")
	public boolean createNota(@RequestBody @Valid Nota nota) {
		return notaService.create(nota);
	}
	
	@GetMapping("/read/{id}")
	public Nota readNota(@PathVariable("id") int id) {
		return notaService.read(id);
	}
	
	@GetMapping("/readall")
	public List<Nota> readAllNotas() {
		return notaService.readAll();
	}
	
	@PutMapping("/update")
	public boolean updateNota(@RequestBody @Valid Nota nota) {
		return notaService.update(nota);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteNota(@PathVariable("id") int id) {
		return notaService.delete(id);
	}
	
	@GetMapping("/readallpage")
	public List<Nota> readAllPageNota(Pageable pageable) {
		return notaService.readAllPage(pageable);
	}
	
}
