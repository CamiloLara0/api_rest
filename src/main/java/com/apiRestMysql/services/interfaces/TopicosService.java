package com.apiRestMysql.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apiRestMysql.entities.Topicos;

@Service
public interface TopicosService {
	
	List<Topicos> findAll();
	
	Topicos findById(int id);
	
	Topicos findByTituloAndMensaje(String titulo, String mensaje);
	
	void deleteById(int id);
	
	boolean existsById(int id);
	
	void save(Topicos topico);
	
	void deleteAll();
}
