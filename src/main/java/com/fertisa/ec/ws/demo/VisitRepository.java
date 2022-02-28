package com.fertisa.ec.ws.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Cargo;
import io.spring.guides.gs_producing_web_service.Driver;
import io.spring.guides.gs_producing_web_service.VisitDetails;

@Component
public class VisitRepository {
	private static final Map<String, List<VisitDetails>> visits = new HashMap<>();

	@PostConstruct
	public void initData() throws Exception {

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

		VisitDetails visitDetails = new VisitDetails();
		visitDetails.setDriver(driver);
		visitDetails.setCargo(cargo);

		List<VisitDetails> visitList = new ArrayList<VisitDetails>();

		visitList.add(visitDetails);

		visits.put("1234", visitList);

		driver = new Driver();
		driver.setMane("Homerito el guapo");
		driver.setIdDriver("a la voz del carshnaval");
		driver.setStartDate(date2);
		driver.setEndDate(date2);

		cargo = new Cargo();
		cargo.setType("CG");
		cargo.setWeight("500 KG");

		visitDetails = new VisitDetails();
		visitDetails.setDriver(driver);
		visitDetails.setCargo(cargo);

		visitList.add(visitDetails);

		visits.put("5678", visitList);

	}

	public List<VisitDetails> findVisitTruck(String idTruck) {

		return visits.get(idTruck);
	}

	public Map<String, List<VisitDetails>> findAllVisit() {
		return visits;
	}
}