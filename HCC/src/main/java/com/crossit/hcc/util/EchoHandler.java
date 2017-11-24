package com.crossit.hcc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {//채팅방에 입장 했을 시.
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		sessionList.add(session);
		System.out.println("채팅방 입장자 : " + session.getPrincipal().getName());

	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		sessionList.remove(session);
		
			}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		super.handleMessage(session, message);
	}

	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handlePongMessage(session, message);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {//session객체에는 메세지를 전송한 사람의 메세지가 담긴다.
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		StringTokenizer tmp = new StringTokenizer(message.getPayload(),"|");
		String getMessage = tmp.nextToken();
		String s_userid = tmp.nextToken();
	
		for(WebSocketSession sess : sessionList){//sessionList란 현재 접속된 모든 사람이 여기에 저장되어 있다.
			
			if(sess.getPrincipal().getName().equals(s_userid)){
				
				sess.sendMessage(new TextMessage(session.getPrincipal().getName()+"|"+getMessage));//for문 도는 로그인한 리스트 중에 if문에 해당되는 아이디에게 메시지를 보냄.
			
			}else if(sess.getPrincipal().getName().equals(session.getPrincipal().getName())){
				
				sess.sendMessage(new TextMessage(session.getPrincipal().getName()+"|"+getMessage));///for문 도는 로그인한 리스트 중에 if문에 해당되는 아이디에게 메시지를 보냄	.

			}
			
		}
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return super.supportsPartialMessages();
	}


	
	

}
