package com.procesos.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.procesos.model.Persona;


@Component
public class JobListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobListener.class);
	
	private JdbcTemplate jdbctemplate;

	@Autowired
	public JobListener(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}
	
@Override
public void afterJob(JobExecution jobExecution) {
if(jobExecution.getStatus()==BatchStatus.COMPLETED) {
	log.info("JOB FINALIZADO");
	jdbctemplate.query("select nombre, apellido, edad from entrada",
			           (rs,row)->new Persona(rs.getString(1),rs.getString(2),rs.getString(3)))
	                   .forEach(persona->log.info("Registo<" + persona + ">"));
			        		   
			        		   
			            
}
}	
	
	
}
