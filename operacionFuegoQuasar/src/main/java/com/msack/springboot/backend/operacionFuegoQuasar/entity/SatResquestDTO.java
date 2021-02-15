package com.msack.springboot.backend.operacionFuegoQuasar.entity;

import java.util.List;

public class SatResquestDTO {
	private double distance;
	private List<String> message;
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	
	
	
}
