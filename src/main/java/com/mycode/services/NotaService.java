package com.mycode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycode.entities.Nota;
import com.mycode.repositories.INotaRepository;

@Service("notaService")
public class NotaService {

	@Autowired
	@Qualifier("notaRepository")
	private INotaRepository notaRepository;
	
	//Registra Nota
	public boolean create(Nota nota) {
		
		try {
			notaRepository.save(nota);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	//Retorna Solo una Nota
	public Nota read(int id) {
		
		try {
			return notaRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	//Retorna Lista de Notas
	public List<Nota> readAll() {
		
		try {
			return notaRepository.findAll();
		} catch (Exception e) {
			List<Nota> emptyNotas = null;
			return emptyNotas;
		}
		
	}
	
	//Actualiza Nota
	public boolean update(Nota nota) {
		
		try {
			Nota obNota = notaRepository.findById(nota.getId());
			if(obNota != null) {
				notaRepository.save(nota);
				return true;
			}else {
				return false;
			}
				
		} catch (Exception e) {
			return false;
		}
		
	}
	
	//Actualiza Delete
	public boolean delete(int id) {
		
		try {
			notaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	//Retorna Lista de Notas con Paginación
	public List<Nota> readAllPage(Pageable pageable){
		return notaRepository.findAll(pageable).getContent();
	}
	
	
	
	
}
