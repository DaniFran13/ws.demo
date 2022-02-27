package com.fertisa.ec.ws.demo;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Cargo;
import io.spring.guides.gs_producing_web_service.Driver;
import io.spring.guides.gs_producing_web_service.Visit;

@Component
public class VisitRepository {
	private static final Map<String, Visit> visits = new HashMap<>();

	@PostConstruct
	public void initData() throws Exception{
		
		Calendar createDate = Calendar.getInstance();
		Date cDate = createDate.getTime();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(cDate);
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		Driver driver = new Driver();
		driver.setMane("Daniela");
		driver.setIdDriver("Para matar");
		driver.setStartDate(date2);
		driver.setEndDate(date2);

		Cargo cargo = new Cargo();
		cargo.setType("CS");
		cargo.setWeight("100 KG");
		
		Visit visit = new Visit();
		visit.setDriver(driver);
		visit.setCargo(cargo);
		
		visits.put("1234", visit);
		
	}

	public Visit findVisitTruck(String idTruck) {
		
		return visits.get(idTruck);
	}
}