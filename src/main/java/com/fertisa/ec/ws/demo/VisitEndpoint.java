//package com.fertisa.ec.ws.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//import io.spring.guides.gs_producing_web_service.FindAllVisitRequest;
//import io.spring.guides.gs_producing_web_service.FindAllVisitResponse;
//import io.spring.guides.gs_producing_web_service.FindVisitTruckRequest;
//import io.spring.guides.gs_producing_web_service.FindVisitTruckResponse;
//
//@Endpoint
//public class VisitEndpoint {
//	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
//
//	private VisitRepository visitRepository;
//
//	@Autowired
//	public VisitEndpoint(VisitRepository visitRepository) {
//		this.visitRepository = visitRepository;
//	}
//
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FindAllVisitRequest")
//	@ResponsePayload
//	public FindAllVisitResponse findAllVisit(@RequestPayload FindAllVisitRequest request) {
//		FindAllVisitResponse response = new FindAllVisitResponse();
//
//		visitRepository.findAllVisit();
//		
//		response.setVisitList();
//
//		return response;
//	}
//	
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
//	        
//	        List<NavisVisitDetails> navisVisitDetails = new ArrayList<NavisVisitDetails>();
//	        navisVisitDetails = navisVisitDetailsService.getNavisVisitByIdTruck(request.getIdTruck());
//	        navisVisitDetails.forEach(
//	                (visitDetails) -> System.out.println(visitDetails.getDriverName() + '-' + visitDetails.getGateIn()));
//	        return response;
//		
//	}
//}