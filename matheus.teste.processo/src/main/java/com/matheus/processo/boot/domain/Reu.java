package com.matheus.processo.boot.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "REU")
public class Reu extends AbstractEntity<Long> {

	
	@NotNull(message = "{NotNull.processo.num_process}")
	@Digits(integer = 30, fraction = 0)
	@Column(nullable = false, length = 30,  unique = true)
	private Integer num_process;
	
	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String requerido;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String reclamado;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String acusado;
	
	@NotNull
	@PastOrPresent(message = "{PastOrPresent.processo.dataEntrada}")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_saida", columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reu_id_fk")
	private Autor reu;


	public String getRequerido() {
		return requerido;
	}

	public void setRequerido(String requerido) {
		this.requerido = requerido;
	}

	public String getReclamado() {
		return reclamado;
	}

	public void setReclamado(String reclamado) {
		this.reclamado = reclamado;
	}
	
	public String getAcusado() {
		return acusado;
	}

	public void setAcusado(String acusado) {
		this.acusado = acusado;
	}
	

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Autor getReu() {
		return reu;
	}

	public void setReu(Autor reu) {
		this.reu = reu;
	}

	public Integer getNum_process() {
		return num_process;
	}

	public void setNum_process(Integer num_process) {
		this.num_process = num_process;
	}
}
