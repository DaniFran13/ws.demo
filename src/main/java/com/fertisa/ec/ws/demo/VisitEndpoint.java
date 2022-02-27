package com.fertisa.ec.ws.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.VisitRequest;
import io.spring.guides.gs_producing_web_service.VisitResponse;

@Endpoint
public class VisitEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private VisitRepository visitRepository;

	@Autowired
	public VisitEndpoint(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "visitRequest")
	@ResponsePayload
	public VisitResponse getVisit(@RequestPayload VisitRequest request) {
		VisitResponse response = new VisitResponse();
		response.setVisit(visitRepository.findVisitTruck(request.getIdTruck()));

		return response;
	}
}