package com.msack.springboot.backend.operacionFuegoQuasar.entity;

import java.util.List;

public class Satellite {
	
	private Coor coor;
	
	private List<String> message;
	
	private double distance;
	
    private String name;
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Coor getCoor() {
		return coor;
	}

	public void setCoor(Coor coor) {
		this.coor = coor;
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}
	
	
	
	
	
	
}
