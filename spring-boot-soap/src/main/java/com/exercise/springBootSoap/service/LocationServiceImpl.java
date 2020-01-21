package com.exercise.springBootSoap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.exercise.springBootSoap.entity.LocationMemoryEntity;
import com.exercise.springBootSoap.repository.LocationDAO;

@Service
public class LocationServiceImpl implements LocationService{
    
	private LocationDAO locationDAO;
	
	@Autowired
	public LocationServiceImpl(LocationDAO theLocationDAO) {
		locationDAO = theLocationDAO;
	}
	
	@Transactional
	public String findClosestLocationNameByPoint(String point) {	
		return locationDAO.findClosestLocationNameByPoint(point);
	}
	
	@Transactional	
	public List<LocationMemoryEntity> findAll() {			
		return locationDAO.findAll();
	}
	
	@Transactional
	public void updateCounterOfClosestRequests(int id){		
		locationDAO.updateCounterOfClosestRequests(id);
	}
	
	@Transactional
	public List<LocationMemoryEntity> findAllWithHigherCounter(int counter){
		return locationDAO.findAllWithHigherCounter(counter);
	}
}
