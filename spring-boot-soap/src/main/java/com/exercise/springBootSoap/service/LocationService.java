package com.exercise.springBootSoap.service;

import java.util.List;
import com.exercise.springBootSoap.entity.LocationMemoryEntity;

public interface LocationService {
	 String findClosestLocationNameByPoint(String point);
	 List<LocationMemoryEntity> findAll();
	 void updateCounterOfClosestRequests(int id);
	 List<LocationMemoryEntity> findAllWithHigherCounter(int counter);
}
