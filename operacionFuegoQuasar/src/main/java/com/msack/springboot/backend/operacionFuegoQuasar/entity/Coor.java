package com.msack.springboot.backend.operacionFuegoQuasar.entity;

public class Coor {
	private double x;
	
	private double y;

	public Coor(double[] points){
        this.setX(points[0]);
        this.setY(points[1]);
    }
	
	public Coor(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double points) {
		this.x = points;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
    @Override
    public String toString(){
        return x+","+y;
    }

	
}
