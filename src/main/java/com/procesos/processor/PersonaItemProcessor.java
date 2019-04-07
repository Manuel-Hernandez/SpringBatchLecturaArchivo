package com.procesos.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.procesos.model.Persona;

public class PersonaItemProcessor implements ItemProcessor<Persona, Persona>{

	private static final Logger log = LoggerFactory.getLogger(PersonaItemProcessor.class);

	@Override
	public Persona process(Persona item) throws Exception {
		String nombre   = item.getNombre().toUpperCase();
		String apellido = item.getApellido().toUpperCase();
		String edad     = item.getEdad();
		
		Persona persona = new Persona(nombre,apellido,edad);
		log.info("en el procesor se manipulan los datos leidos");
		log.info("convirtiendo ("+item+") a ("+persona+")");
		return persona;
	}

}
