package com.matheus.processo.boot.dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matheus.processo.boot.domain.Reu;

@Repository
public class ProcessoDaoImpl extends AbstractDao<Reu, Long> implements ProcessoDao {

	@Override
	public List<Reu> findByNome(String nome) {		
	return createQuery("select f from reu f where f.acusado like concat('%',"+nome+",'%') ");

	}

	@Override
	public List<Reu> findByCargoId(Long id) {		
		List<Reu> Lista = null;
		try {
		Lista = createQuery("select f from reu f where f.cargo.id = ?1", id);
		}catch (Exception e) {
		e.printStackTrace();	
		error(null);
		}
		return Lista;
	}

	public void error(RedirectAttributes attr) {		
	attr.addFlashAttribute("fail", "Não encontrado.");
	}
	
	
	@Override
	public List<Reu> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		
		String jpql = new StringBuilder("select f from reu f ")
				.append("where f.dataEntrada >= ?1 and f.dataSaida <= ?2 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Reu> findByDataEntrada(LocalDate entrada) {

		String jpql = new StringBuilder("select f from reu f ")
				.append("where f.dataEntrada >= ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Reu> findByDataSaida(LocalDate saida) {

		String jpql = new StringBuilder("select f from reu f ")
				.append("where f.dataSaida <= ?1 ")
				.append("order by f.dataEntrada asc")
				.toString();
		return createQuery(jpql, saida);
	}
	
	
}
