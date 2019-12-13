package com.mycode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycode.entities.AuthRol;

@Repository("rolRepository")
public interface IAuthRolRepository extends JpaRepository<AuthRol,Integer> {

}


