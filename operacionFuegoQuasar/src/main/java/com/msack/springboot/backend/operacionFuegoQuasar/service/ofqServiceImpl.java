package com.msack.springboot.backend.operacionFuegoQuasar.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import com.msack.springboot.backend.operacionFuegoQuasar.entity.Coor;
import com.msack.springboot.backend.operacionFuegoQuasar.entity.Response;
import com.msack.springboot.backend.operacionFuegoQuasar.entity.SatResquestDTO;
import com.msack.springboot.backend.operacionFuegoQuasar.entity.Satellite;
import com.msack.springboot.backend.operacionFuegoQuasar.entity.SetSatellites;

@Service
public class ofqServiceImpl implements ofqService{
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private LocationService locationService;
	
	 @Autowired
    private Environment environment;
	 
	private  SetSatellites postSatellites = new SetSatellites();
	 
	private static final int NUMBERSAT = 3; 

	@Override
	public Response getShip(RequestEntity requestEntity) throws Exception {
		SetSatellites setSatellites = (SetSatellites)requestEntity.getBody();
		return getData(setSatellites);
	}
	
	/* Posiciono los satelites con las constantes del ejercicio.*/
	public void uploadCoorsSatellites(SetSatellites setSatellites){

        if(setSatellites.getCoors()[0] == null) {
            int numberSat = NUMBERSAT;
            double[][] pointsList = new double[numberSat][];
            String[] satellitePos;
            for (int i = 0; i < setSatellites.getSatellites().size(); i++) {
                satellitePos = environment.getProperty(setSatellites.getSatellites().get(i).getName()+ ".coor").split(",");
                pointsList[i] = Arrays.stream(satellitePos)
                        .map(Double::valueOf)
                        .mapToDouble(Double::doubleValue)
                        .toArray();
            }
            setSatellites.setCoors(pointsList);
        }
    }

	@Override
	public String postSatellite(String name,SatResquestDTO req) throws Exception {

		String nameSat = environment.getProperty(name+ ".coor");
		if(nameSat == null) {
			throw new Exception("Nombre de Satelite Incorrecto");
		}
		
		Satellite sat = new Satellite();
		sat.setName(name);
		sat.setDistance(req.getDistance());
		sat.setMessage(req.getMessage());
		
		this.postSatellites.addSatellite(sat);
		return "Satelite creado con exito";
	}

	@Override
	public Response getSatellite() throws Exception {
		SetSatellites setSatellites = this.postSatellites;
		
		return getData(setSatellites);
		
	}
	
	
	private Response getData(SetSatellites setSatellites) throws Exception{
		if(setSatellites.getMessages().size() < 2)
            throw new Exception("Nro de mensajes insuficientes");
        String message = messageService.getMessage(setSatellites.getMessages());

        uploadCoorsSatellites(setSatellites);
        if( (setSatellites.getCoors().length < 2) || (setSatellites.getDistances().length < 2) )
            throw new Exception("Nro posicion o distancias insuficientes");
        double [] points = locationService.getLocation(setSatellites.getCoors(), setSatellites.getDistances());
        Coor coor = new Coor(points);

        return new Response(coor, message);
	}
}
