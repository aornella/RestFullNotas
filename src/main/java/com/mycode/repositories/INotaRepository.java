package com.mycode.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mycode.entities.Nota;

@Repository("notaRepository")
public interface INotaRepository extends JpaRepository<Nota,Integer>, PagingAndSortingRepository<Nota, Integer> {
	
	public abstract Nota findById(int id);
	public abstract Nota findByNombre(String nombre);
	public abstract List<Nota> findAll();
	public abstract Page<Nota> findAll(Pageable pageable);
	
}
