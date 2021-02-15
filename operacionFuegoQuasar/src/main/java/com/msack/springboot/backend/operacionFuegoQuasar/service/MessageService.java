package com.msack.springboot.backend.operacionFuegoQuasar.service;

import java.util.List;

public interface MessageService {
	public List<String> getListWord(List<List<String>> msgList);
	public void removeGap(List<List<String>> msgList, int gapSize);
    public String completeMessage(List<List<String>> msgList);
    public String getMessage(List<List<String>> msgList) throws Exception;
    public boolean validateMessagesSize(List<List<String>> messages, int size);
    public boolean validateMessageFinal(List<String> phrases, String message);
}
