package com.apiRestMysql.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apiRestMysql.entities.Topicos;
import com.apiRestMysql.repository.TopicosRepository;
import com.apiRestMysql.services.interfaces.TopicosService;

@Component
public class TopicosImpl implements TopicosService{
	
	@Autowired
	private TopicosRepository repo;

	@Override
	public List<Topicos> findAll() {
		return repo.findAll();
	}

	@Override
	public Topicos findById(int id) {
		return repo.findById(id);
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public boolean existsById(int id) {
		return repo.existsById(id);
	}

	@Override
	public void save(Topicos topico) {
		repo.save(topico);
		
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
		
	}

	@Override
	public Topicos findByTituloAndMensaje(String titulo, String mensaje) {
		return repo.findByTituloAndMensaje(titulo, mensaje);
	}

}
