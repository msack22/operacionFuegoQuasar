package com.msack.springboot.backend.operacionFuegoQuasar.entity;

public class Response {
	private Coor coor;
	private String message;
	
	public Response(Coor coor, String message) {
		super();
		this.coor = coor;
		this.message = message;
	}
	
	
	public Coor getCoor() {
		return coor;
	}
	public void setCoor(Coor coor) {
		this.coor = coor;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
