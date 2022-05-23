

package com.matheus.processo.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.matheus.processo.boot.domain.Reu;

public interface ProcessoService {

	void salvar(Reu reu);
	
	void editar(Reu reu);
	
	void excluir(Long id);
	
	Reu buscarPorId(Long id);
	
	List<Reu> buscarTodos();

	List<Reu> buscarPorNome(String nome);

	List<Reu> buscarPorDatas(LocalDate entrada, LocalDate saida);
}
