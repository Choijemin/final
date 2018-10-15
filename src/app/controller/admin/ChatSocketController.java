package app.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

@Controller
public class ChatSocketController extends TextWebSocketHandler {
	@Autowired
	Gson gson;
	
	List<WebSocketSession> sockets;
	public ChatSocketController() {
		sockets = new ArrayList<>();
	}
	
	// 웹 소켓으로 데이터가 들어올 때 작동한다.
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sockets.add(session);
		Map<String, Object> attrs = session.getAttributes();	
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(int i = 0; i < sockets.size(); i++) {
			try {
			sockets.get(i).sendMessage(message);
		}catch (Exception e) {
			e.printStackTrace();
			
		 }
	  }
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sockets.remove(session);
	}
	
}
