package com.fertisa.ec.ws.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fertisa.ec.ws.demo.data.NavisVisitDetailsRepository;
import com.fertisa.ec.ws.demo.model.NavisVisitDetails;

@Service
public class NavisVisitDetailsService implements INavisVisitDetailsService {
	
	@Autowired
	private NavisVisitDetailsRepository navisVisitDetailsRepository;
	
	public NavisVisitDetails getNavisVisitDetailsById(long id) {
		return navisVisitDetailsRepository.findById(id).orElse(null);
	}

	public List<NavisVisitDetails> getNavisVisitDetailsAll() {
		return navisVisitDetailsRepository.findAll();
	}
	
	public List<NavisVisitDetails> getNavisVisitByIdTruck(String idTruck) {
		return navisVisitDetailsRepository.findByIdTruck(idTruck);
	}
	
}




