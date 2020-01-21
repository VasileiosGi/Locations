package com.exercise.springBootSoap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
public class LocationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;	
	
	@Column(name="closest_requests")
	private int closestRequests;
		
	
	@Column(name="location")
	private String location;

	
	public LocationEntity() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClosestRequests() {
		return closestRequests;
	}

	public void setClosestRequests(int closestRequests) {
		this.closestRequests = closestRequests;
	}

	public String getLocation() {
		
		return location;
	}

	public void setLocation(String location) {		
		this.location = location;	
	}

	@Override
	public String toString() {
		return "LocationEntity [id=" + id + ", name=" + name
				+ ", closestRequests=" + closestRequests + ", location="
				+ location + "]";
	}
	

}
