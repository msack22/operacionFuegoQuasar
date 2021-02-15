package com.msack.springboot.backend.operacionFuegoQuasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.msack.springboot.backend.operacionFuegoQuasar.entity.SatResquestDTO;
import com.msack.springboot.backend.operacionFuegoQuasar.entity.SetSatellites;
import com.msack.springboot.backend.operacionFuegoQuasar.service.ofqService;



@RestController
@RequestMapping(path = "${oft.context.path}")
public class ofqController {
	@Autowired
    private ofqService ofqService; 

    @SuppressWarnings("rawtypes")
	@PostMapping(path = "/topsecret", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity topSecret(RequestEntity<SetSatellites> requestEntity){
        try {
        	
            return ResponseEntity.status(HttpStatus.OK).body(ofqService.getShip(requestEntity));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
    
    @SuppressWarnings("rawtypes")
	@PostMapping(path = "/topsecret_split/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postTopsecret_split(@PathVariable String name, @RequestBody SatResquestDTO resquestDTO){
        try {
        	
        	return ResponseEntity.status(HttpStatus.OK).body(ofqService.postSatellite(name,resquestDTO));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
    
    
    @SuppressWarnings("rawtypes")
	@GetMapping(path = "/topsecret_split/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTopsecret_split(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ofqService.getSatellite());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
    

}
