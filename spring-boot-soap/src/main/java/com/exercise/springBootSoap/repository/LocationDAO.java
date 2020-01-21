package com.exercise.springBootSoap.repository;

import java.util.List;

import com.exercise.springBootSoap.entity.LocationMemoryEntity;

public interface LocationDAO {
	
	 String findClosestLocationNameByPoint(String point);
	
	 List<LocationMemoryEntity> findAll();
	
	 void updateCounterOfClosestRequests(int id);
	
	 List<LocationMemoryEntity> findAllWithHigherCounter(int counter);
}
