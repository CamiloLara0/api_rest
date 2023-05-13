package com.apiRestMysql.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="topicos")
public class Topicos  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="titulo",nullable=false,length=60,unique=true)
	private String titulo;
	@Column(name="mensaje",nullable=false,length=60,unique=true)
	private String mensaje;
	@Column(name="fecha_creacion",nullable=false)
	private LocalDate fechaCreacion;
	@Column(name="fecha_actualizacion",nullable=false)
	private LocalDate fechaActualizacion;
	@Column(name="estatus",nullable=false,length=15)
	private String estatus;
	@Column(name="autor",nullable=false,length=45)
	private String autor;
	@Column(name="curso",nullable=false,length=60)
	private String curso;
	
	public Topicos() {
		
	}
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion = LocalDate.now();
		this.fechaActualizacion = LocalDate.now();
	}
	
	@PostUpdate
	public void updatePersist() {
		this.fechaActualizacion = LocalDate.now();
	}

	public Topicos(String titulo, String mensaje, String estatus, String autor, String curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.estatus = estatus;
		this.autor = autor;
		this.curso = curso;
	}
	
	public void upDate(Topicos nuevo) {
		this.titulo = nuevo.getTitulo();
		this.mensaje = nuevo.getMensaje();
		this.estatus = nuevo.getEstatus();
		this.autor = nuevo.getAutor();
		this.curso = nuevo.getCurso();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	
	

	public LocalDate getFechaActualizacion() {
		return fechaActualizacion;
	}

	@Override
	public String toString() {
		return "Topicos [id=" + id + ", titulo=" + titulo + ", mensaje=" + mensaje + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + ", estatus=" + estatus + ", autor=" + autor
				+ ", curso=" + curso + "]";
	}



	

	
	
	
}
