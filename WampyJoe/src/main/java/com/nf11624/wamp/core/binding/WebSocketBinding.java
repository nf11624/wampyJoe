package com.nf11624.wamp.core.binding;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketBinding implements WebSocketHandler {

	public void afterConnectionClosed(WebSocketSession arg0, CloseStatus arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterConnectionEstablished(WebSocketSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1) throws Exception {
		// Message message =

	}

	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
