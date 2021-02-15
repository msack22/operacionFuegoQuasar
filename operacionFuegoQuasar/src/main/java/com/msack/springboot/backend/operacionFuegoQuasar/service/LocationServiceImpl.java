package com.msack.springboot.backend.operacionFuegoQuasar.service;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

@Service
public class LocationServiceImpl implements LocationService {
	 public double[] getLocation(double[][] positions, double [] distances) {

        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());

        return  nSolver.solve().getPoint().toArray();
    }
}
