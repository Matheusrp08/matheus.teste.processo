package com.matheus.processo.boot.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer> {

	@Override
	public Integer convert(String text) {

		text.trim();
		
		if(text.matches("[0-9]+"))
			return Integer.valueOf(text);
			
		return null;
	}

}
