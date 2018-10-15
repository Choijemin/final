package app.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import app.model.EmplyoeeDao;

@Controller
public class MessageController {
	@Autowired
	EmplyoeeDao emplyoee;
		
	@GetMapping("/send.do")
	public String sendGetHandle() {
		
		return "send.employee.home";
	}
	@PostMapping("/send.do")
	public String sendPostHandle(WebRequest wr, ModelMap mmp) {
		String send = (String)wr.getAttribute("id", wr.SCOPE_SESSION);
		String receiver = (String)wr.getParameter("receiver");
		String content = (String)wr.getParameter("content");
		java.sql.Date senddate = new java.sql.Date(System.currentTimeMillis());
		
		Map map = new HashMap<>();
		map.put("send", send);
		map.put("receiver", receiver);
		map.put("content", content);
		map.put("senddate", senddate);
		
		if(receiver != null && content != null) {
		int m = emplyoee.addmail(map);
		return "admin.employee.home";
		}else {
			mmp.put("err", "on");
			return "send.employee.home";
		}	
	}
}