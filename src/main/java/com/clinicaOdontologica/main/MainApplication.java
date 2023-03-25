package com.clinicaOdontologica.main;

import com.clinicaOdontologica.main.repository.impl.OdontologoDaoH2;
import com.clinicaOdontologica.main.service.OdontologoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(MainApplication.class, args);

		//Odontologo odontologo = new Odontologo(4L, "Carlos", "matias", 1231);
		OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
		System.out.println(odontologoService.share(2L));
		//odontologoService.save(odontologo);

		//Odontologo odontologo1 = new Odontologo(3L, "Javier", "matias",4532);

		//odontologoService.update(odontologo1, 3l);
	}


}
