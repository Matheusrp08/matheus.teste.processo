package com.matheus.processo.boot.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matheus.processo.boot.dao.ProcessoDao;
import com.matheus.processo.boot.domain.Reu;

@Service
@Transactional(readOnly = true)
public class ProcessoServiceImpl implements ProcessoService{

	@Autowired
	private ProcessoDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void salvar(Reu reu){
		dao.save(reu);
	}

	@Override
	@Transactional(readOnly = false)
	public void editar(Reu reu) {
		dao.update(reu);
	}

	@Override
	@Transactional(readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Reu buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Reu> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Reu> buscarPorNome(String nome) {
		List<Reu> lista = null;
		try {
		lista =  dao.findByNome(nome);
		}catch (Exception e) {
		e.printStackTrace();
		Erro(null);
		
		}
		return lista;
	}
	
	public void Erro(RedirectAttributes attr) {
	System.out.println("entrando aqui == ");
	attr.addFlashAttribute("success", "Não obteve Sucesso.");	
	}


	@Override
	public List<Reu> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		
		if(entrada != null && saida != null)
			return dao.findByDataEntradaDataSaida(entrada, saida);
		else if(entrada != null)
			return dao.findByDataEntrada(entrada);
		else if(saida != null)
			return dao.findByDataSaida(saida);
		else
			return new ArrayList<>();
	}
}
