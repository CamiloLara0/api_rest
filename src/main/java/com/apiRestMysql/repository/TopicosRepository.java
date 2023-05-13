package com.apiRestMysql.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apiRestMysql.entities.Topicos;


@Repository
public interface TopicosRepository extends CrudRepository<Topicos, Integer>{
	
	List<Topicos> findAll();
	
	Topicos findByTituloAndMensaje(String titulo, String mensaje);
	
	Topicos findById(int id);
	}
