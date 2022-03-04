package com.fertisa.ec.ws.demo;


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.fertisa.ec.ws.demo.data.NavisVisitDetailsRepository;
import com.fertisa.ec.ws.demo.model.NavisVisitDetails;

import io.spring.guides.gs_producing_web_service.Cargo;
import io.spring.guides.gs_producing_web_service.Driver;
import io.spring.guides.gs_producing_web_service.FindAllVisitRequest;
import io.spring.guides.gs_producing_web_service.FindAllVisitResponse;
import io.spring.guides.gs_producing_web_service.VisitDetails;

@Endpoint
public class VisitEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	//private VisitRepository visitRepository;
	private NavisVisitDetailsRepository navisVisitDetailsRepository;

//	@Autowired
//	public VisitEndpoint(VisitRepository visitRepository) {
//		this.visitRepository = visitRepository;
//	}
	
	@Autowired
	public VisitEndpoint(NavisVisitDetailsRepository navisVisitDetailsRepository) {
		this.navisVisitDetailsRepository = navisVisitDetailsRepository;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FindAllVisitRequest")
	@ResponsePayload
	public FindAllVisitResponse findAllVisit(@RequestPayload FindAllVisitRequest request) {
		
		FindAllVisitResponse response = new FindAllVisitResponse();
		Driver driver;
		Cargo cargo;
		VisitDetails visitDetail = new VisitDetails();

		List<NavisVisitDetails> list = navisVisitDetailsRepository.findAll();
		
		for(NavisVisitDetails n:list) {
			driver = new Driver();
			cargo = new Cargo();
			visitDetail = new VisitDetails();
			driver.setDriverName(n.getDriverName());
			driver.setIdDriver(n.getIdDriver());
			try {
				driver.setStartDate(getXmlGregorianCalendarFromDate(n.getGateIn()));
				driver.setEndDate(getXmlGregorianCalendarFromDate(n.getGateOut()));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cargo.setType(n.getCargoType());
			cargo.setWeight(n.getWeight());
			visitDetail.setDriver(driver);
			visitDetail.setCargo(cargo);
			response.getVisitDetails().add(visitDetail);
		}
		return response;
		
		
	}

//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FindAllVisitRequest")
//	@ResponsePayload
//	public FindAllVisitResponse findAllVisit(@RequestPayload FindAllVisitRequest request) {
//		VisitList visitList = new VisitList();
//		FindAllVisitResponse response = new FindAllVisitResponse();
//
//		visitList= visitRepository.findAllVisit();
//		
//		response.setVisitList();
//
//		return response;
//		
//		
//	}
	
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FindVisitTruckRequest")
//	@ResponsePayload
//	public FindVisitTruckResponse findVisitTruckId(@RequestPayload FindVisitTruckRequest request) {
//		FindVisitTruckResponse response = new FindVisitTruckResponse();
//
//		response.setVisitList(visitRepository.findVisitTruck(request.getIdTruck()));
//
//		return response;
//		
//	        
//	        List<NavisVisitDetails> navisVisitDetails = new ArrayList<NavisVisitDetails>();
//	        
//	        navisVisitDetails = navisVisitDetailsService.getNavisVisitByIdTruck(request.getIdTruck());
//	        
//	        navisVisitDetails.forEach(
//	                (visitDetails) -> System.out.println(visitDetails.getDriverName() + '-' + visitDetails.getGateIn()));
//	        return response;
//		
//	}
	
	
public static XMLGregorianCalendar getXmlGregorianCalendarFromDate(final Date date) throws DatatypeConfigurationException{
	
    GregorianCalendar calendar = new GregorianCalendar();
	
    calendar.setTime(date);
	
    return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

}
}
