package app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;

@Service
public class SocketService {
	List<WebSocketSession> list;
	
	@Autowired
	Gson gson;
	
	public SocketService() {
		list = new ArrayList<>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean addSocket(WebSocketSession target) {
		return list.add(target);
		// socket 저장하고
	}
	
	public boolean removeSocket(WebSocketSession target) {
		return list.remove(target);
		// socket 제거하고
	}
	
	public void sendAll(String txt) {
		TextMessage msg = new TextMessage(txt);
		for(int i = 0; i < list.size(); i++) {
			try {
				list.get(i).sendMessage(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void sendAll(Map map) {
		sendAll(gson.toJson(map));
	}
	
	public void sendOne(String txt, String target) {
		TextMessage msg = new TextMessage(txt);
		for(int i = 0; i < list.size(); i++) {
			try {
				WebSocketSession ws = list.get(i);
				String userid = (String)ws.getAttributes().get("id");
				// ws.getAttribute() == HttpSession의 attribute 들
				if(userid.equals(target)) {
					ws.sendMessage(msg);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public void sendOne(Map data, String target) {
		sendOne(gson.toJson(data), target);
	}
	
	public void sendSome(String txt, String... target) { // 이렇게 하면 target이 string 배열로 나온다.
		TextMessage msg = new TextMessage(txt);
		for(int i = 0; i < list.size(); i++) {
			
		}
	}
	
}