package com.msack.springboot.backend.operacionFuegoQuasar.service;

public interface LocationService {
	public double[] getLocation(double[][] positions, double [] distances);
}
