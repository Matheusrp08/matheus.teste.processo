package com.matheus.processo.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.matheus.processo.boot.domain.Reu;

public class ProcessoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Reu.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Reu processo = (Reu) object;
		LocalDate entrada = processo.getDataEntrada();
	
		
		if(processo.getDataSaida() != null && processo.getDataSaida().isBefore(entrada))
			errors.rejectValue("dataSaida", "PosteriorDataEntrada.processo.dataSaida");
	}

}
