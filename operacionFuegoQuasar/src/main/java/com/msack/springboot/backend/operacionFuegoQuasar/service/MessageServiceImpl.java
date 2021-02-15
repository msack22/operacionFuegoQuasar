package com.msack.springboot.backend.operacionFuegoQuasar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
	
	/* Armo una lista de palabras a partir de las 3 listas de mensajes, removiendo las palabras duplicados	 */
	   public List<String> getListWord(List<List<String>> msgList){

	        List<String> listWords = new ArrayList<String>();
	        for( List<String> msg : msgList){
	            listWords = Stream.concat(listWords.stream(), msg.stream())
	                    .distinct()
	                    .collect(Collectors.toList());
	        }
	        listWords.remove("");
	        return listWords;
	    }
	   
	   
	   /* Saco siempre las ultimas x(gapSize) pocisiones */
	    public void removeGap(List<List<String>> msgList, int gapSize){
	    	
	    	msgList.stream().forEach(s -> {
	        int size = s.size();	
	        msgList.set(msgList.indexOf(s),s.subList(size-gapSize, s.size()));
	        
	    	});
	
	        
	    }
	    
	    

	    
	    public String completeMessage(List<List<String>> msgList){

	        String o = "";
	        String phrase = ""; 
	      
	        for (int i = 0; i < msgList.size(); i++) {	
	        	for(List<String> m : msgList){

		            if(m.size()>0 && !m.get(0).equals("")){
		                phrase = (m.size() == 1) ? m.get(0) : m.get(0) + " ";
		                msgList.stream().forEach( s -> s.remove(0));
		                o = o + phrase;
		            }
		        }
	        	
			}
	        	        
	        return o;
	    }
	    
	    

	    public String getMessage(List<List<String>> msgList) throws Exception {

	        List<String> listWord = getListWord(msgList);
	        if(!validateMessagesSize(msgList, listWord.size())) {
	        	throw new Exception("Tamaño del mensaje incorrecto");	        	
	        }
	        
	        removeGap(msgList,listWord.size());
	        String message = completeMessage(msgList);
	        
	        if(!validateMessageFinal(listWord,message)) {
	        	throw new Exception("No se puede conocer el mensaje");	        	
	        }

	        return message;
	    }
	    
	    /*Validos que todos los mensajes al menos tengan la misma o mayor cantidad de mensajes getMsgPhrases */
	    public boolean validateMessagesSize(List<List<String>> messages, int size){
	        for(List<String> m : messages){
	            if(m.size() < size){
	                return false;
	            }
	        }
	               
	        return true;
	    }
	   
	    public boolean validateMessageFinal(List<String> phrases, String message){
	        List<String> msg = Arrays.stream(message.split(" ")).collect(Collectors.toList());
	        Collections.sort(phrases);
	        Collections.sort(msg);
	        return Arrays.equals(phrases.toArray(), msg.toArray());
	    }
	
}	
