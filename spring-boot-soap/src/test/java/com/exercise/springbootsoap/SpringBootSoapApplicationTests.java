package com.exercise.springbootsoap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.exercise.springBootSoap.controller.LocationController;
import com.xmltojavaobjects.GetListWithHigherCounterRequest;
import com.xmltojavaobjects.GetListWithHigherCounterResponse;
import com.xmltojavaobjects.GetNearestPointRequest;
import com.xmltojavaobjects.GetNearestPointResponse;

@SpringBootTest
class SpringBootSoapApplicationTests {

	@Autowired
	private LocationController locationController;
	
	@Test
	void contextLoads() {
		assertThat(locationController).isNotNull();
	}
	
	@Test
	void getNearestPointName(){
		GetNearestPointRequest gp= new GetNearestPointRequest();
		gp.setLatitude(5);
		gp.setLongitude(5);		
		GetNearestPointResponse response = locationController.getNearestPointRequest(gp);	
		assertThat(response.getNearestPointName()).isEqualTo("AA");
	}
	
	@Test
	void getListWithHigherCounter(){
		GetListWithHigherCounterRequest gc=new GetListWithHigherCounterRequest();
		gc.setCounter(1);
		GetListWithHigherCounterResponse response=locationController.getListWithHigherCounterRequest(gc);
		assertThat(response.getListWithHigherCouner()).isNotEmpty();
	}

}
