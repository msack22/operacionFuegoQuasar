package com.msack.springboot.backend.operacionFuegoQuasar.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetSatellites {
	private List<Satellite> satellites;
	
	
	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}
	
	public void addSatellite(Satellite sat) {
		Boolean add = false;
		if(this.getSatellites() == null) {
			List<Satellite> list = new ArrayList<Satellite>();
			this.setSatellites(list);
		}
		for (Satellite satellite : this.getSatellites()) {
			if(satellite.getName().equals(sat.getName())) {
				satellite.setDistance(sat.getDistance());
				satellite.setMessage(sat.getMessage());
				add = true;
				break;
			}
		}
		if(!add) {
			this.getSatellites().add(sat);			
		}
	}
	
	public double[] getDistances() {
		double [] distances = new double[satellites.size()];
        for(int i = 0; i < satellites.size(); i ++){
            distances[i] = satellites.get(i).getDistance();
        }
        return  distances;
	}

	public double[][] getCoors(){
        double [][] positions = new double[satellites.size()][];
        String[] points;
        for(int i = 0; i < satellites.size(); i ++){
            if(satellites.get(i).getCoor() != null) {
                points = satellites.get(i).getCoor().toString().split(",");
                positions[i] = Arrays.stream(points)
                        .map(Double::valueOf)
                        .mapToDouble(Double::doubleValue)
                        .toArray();
            }
        }
        return positions;
    }

    public void setCoors(double[][] pointsList){
        Coor position;
        for(int i = 0; i < pointsList.length; i++){
            position = new Coor(pointsList[i]);
            satellites.get(i).setCoor(position);
        }
    }
    
    
    public List<List<String>> getMessages(){
        List<List<String>> messages = new ArrayList<List<String>>();
        for(Satellite s : satellites){
            messages.add(s.getMessage());
        }
        return  messages;
    }
	
}
