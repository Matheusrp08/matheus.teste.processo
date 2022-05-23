package com.matheus.processo.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.matheus.processo.boot.domain.Reu;

public interface ProcessoDao {

	void save(Reu reu);
	
	void update(Reu reu);
	
	void delete(Long id);
	
	Reu findById(Long id);
	
	List<Reu> findAll();
	
	List<Reu> findByNome(String nome);
	
	List<Reu> findByCargoId(Long id);

	List<Reu> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	List<Reu> findByDataEntrada(LocalDate entrada);

	List<Reu> findByDataSaida(LocalDate saida);
	
	}
