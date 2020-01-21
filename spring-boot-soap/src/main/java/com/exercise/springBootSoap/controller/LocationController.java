package com.exercise.springBootSoap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.exercise.springBootSoap.entity.LocationMemoryEntity;
import com.exercise.springBootSoap.service.LocationService;
import com.xmltojavaobjects.GetListWithHigherCounterRequest;
import com.xmltojavaobjects.GetListWithHigherCounterResponse;
import com.xmltojavaobjects.GetNearestPointRequest;
import com.xmltojavaobjects.GetNearestPointResponse;
import com.xmltojavaobjects.Location;

@Endpoint
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PayloadRoot(namespace = "http://www.xmlToJavaObjects.com", localPart = "getNearestPointRequest")
	@ResponsePayload
	public GetNearestPointResponse getNearestPointRequest(
			@RequestPayload GetNearestPointRequest request) {
		GetNearestPointResponse response = new GetNearestPointResponse();

		List<LocationMemoryEntity> listOfLocations = locationService.findAll();
		
		double smallestDistance = 0.0;
		String nearestPointName = "";
		int nearestPointId = 0;
		for (LocationMemoryEntity len : listOfLocations) {

			double distance = Math.hypot(
					request.getLatitude() - len.getLatitude(),
					request.getLongitude() - len.getLongitude());

			if (smallestDistance != 0.0) {
				if (distance <= smallestDistance) {
					smallestDistance = distance;
					nearestPointName = len.getName();
					nearestPointId = len.getId();
					if (distance == 0) {
						break;
					}
				}
			} else {
				smallestDistance = distance;
				nearestPointName = len.getName();
				nearestPointId = len.getId();
			}

		}

		response.setNearestPointName(nearestPointName);
		locationService.updateCounterOfClosestRequests(nearestPointId);
		return response;
	}

	@PayloadRoot(namespace = "http://www.xmlToJavaObjects.com", localPart = "getListWithHigherCounterRequest")
	@ResponsePayload
	public GetListWithHigherCounterResponse getListWithHigherCounterRequest(
			@RequestPayload GetListWithHigherCounterRequest request) {
		GetListWithHigherCounterResponse response = new GetListWithHigherCounterResponse();

		List<LocationMemoryEntity> le = locationService
				.findAllWithHigherCounter(request.getCounter());

		le.stream().map(Location::new)
				.forEach(response.getListWithHigherCouner()::add);

		return response;
	}

}
