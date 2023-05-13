package com.apiRestMysql.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiRestMysql.entities.Topicos;
import com.apiRestMysql.repository.TopicosRepository;
import com.apiRestMysql.services.implementations.TopicosImpl;




@RestController
public class ApiRestController {
	//TopicosRepository repositorio;
	
	private TopicosImpl crud;
	
	public ApiRestController(TopicosImpl repo) {
		this.crud = repo;
	}
	

	@GetMapping("/topicos")
	public List<Topicos> ejemplo() {
		return crud.findAll();
	}
	
	@GetMapping("/topicos/{id}")
	public ResponseEntity<Topicos> getTopicoById(@PathVariable Integer id) {
		 Topicos consultado = crud.findById(id);
		 if(consultado!=null) {
			 return ResponseEntity.ok(consultado);
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	}
	
	@PostMapping("/topicos")
	public ResponseEntity<Topicos> saveTopico(@Validated @RequestBody Topicos topico) {
		
		if(crud.findByTituloAndMensaje(topico.getTitulo(), topico.getMensaje())==null) {
			crud.save(topico);
			return ResponseEntity.ok(topico);
		}else {
			return ResponseEntity.badRequest().build();	
	   }
	}
	
	@PutMapping("/topicos/{id}")
	public ResponseEntity<Topicos> upDateById(@PathVariable Integer id, @RequestBody Topicos topico) {
		 Topicos consultado = crud.findById(id);
		 if(consultado!=null) {
			 consultado.upDate(topico);
			 crud.save(consultado);
			 return ResponseEntity.ok(crud.findById(consultado.getId()));
		 }else {
			 return ResponseEntity.notFound().build();
		 }
	}
	
	
	@DeleteMapping("/topicos/{id}")
	public ResponseEntity<Topicos> deleteById(@PathVariable int id){
		if(crud.existsById(id)) {
			crud.deleteById(id);
		    return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.badRequest().build();	
		}
	}
	
	@DeleteMapping("/topicos")
	public ResponseEntity<Topicos> deleteAll(){
		crud.deleteAll();
		return ResponseEntity.noContent().build();
	}
}
