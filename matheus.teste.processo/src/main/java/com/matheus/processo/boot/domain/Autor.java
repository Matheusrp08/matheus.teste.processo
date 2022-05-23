package com.matheus.processo.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "AUTHOR")
public class Autor extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String requerente;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String reclamante;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String autor;
	

	@NotNull(message = "{NotNull.reu.uf}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@NotBlank
	@Size(min = 9, max = 9, message = "{Size.reu.cep}")
	@Column(nullable = false, length = 9)
	private String cep;
	
	
	public String getRequerente() {
		return requerente;
	}

	public void setRequerente(String requerente){
		this.requerente = requerente;
	}
	
	public String getReclamante() {
		return reclamante;
	}

	public void setReclamante(String reclamante) {
		this.reclamante = reclamante;
	}
	
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
