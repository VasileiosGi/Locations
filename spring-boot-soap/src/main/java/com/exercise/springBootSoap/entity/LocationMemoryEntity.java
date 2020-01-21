package com.exercise.springBootSoap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="locations_memory")
public class LocationMemoryEntity {

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

	@Transient
	private double latitude;
	
	@Transient
	private double longitude;
	
	public LocationMemoryEntity() {
		
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
	
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = Double.valueOf(getLocation().substring(
				getLocation().indexOf(" ")));;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = Double.valueOf(getLocation().substring(0,
				getLocation().indexOf(" ")));
	}

	@Override
	public String toString() {
		return "LocationEntity [id=" + id + ", name=" + name
				+ ", closestRequests=" + closestRequests + ", location="
				+ location + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}











