package com.fertisa.ec.ws.demo.services;

import java.util.List;

import com.fertisa.ec.ws.demo.model.NavisVisitDetails;

public interface INavisVisitDetailsService {
	
	public NavisVisitDetails getNavisVisitDetailsById(long id);

	public List<NavisVisitDetails> getNavisVisitDetailsAll();
	
	public List<NavisVisitDetails> getNavisVisitByIdTruck(String idTruck);

}
