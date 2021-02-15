package com.msack.springboot.backend.operacionFuegoQuasar.service;

import org.springframework.http.RequestEntity;

import com.msack.springboot.backend.operacionFuegoQuasar.entity.Response;
import com.msack.springboot.backend.operacionFuegoQuasar.entity.SatResquestDTO;

public interface ofqService {
	public Response getShip(RequestEntity requestEntity) throws Exception;
	public String postSatellite(String name,SatResquestDTO req) throws Exception;
	public Response getSatellite() throws Exception;
	
	
}

