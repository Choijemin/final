package app.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import app.model.EmplyoeeDao;
import app.service.SocketService;

@Controller
public class IndexController {
	Map<String, HttpSession> sessions;
	
	public IndexController() {
		sessions = new HashMap<>();
	}
	
	
	@Autowired
	EmplyoeeDao Emplyoee;
	@Autowired
	SocketService socketService;
	@GetMapping("/index.do")
	public String GetindexHandle(WebRequest web, ModelAndView mav) {
		System.out.println("index에 들어왔어요");

		if (web.getAttribute("auth", web.SCOPE_SESSION) == null) {
			return "index";
		} else {
			return "admin.employee.home";

		}
	}

	@PostMapping("/login.do")
	public String loginHandle(WebRequest wr, ModelMap map, HttpSession session) {
		System.out.println("======================================");
		System.out.println("login.do에 들어왔어요");
		String id = (String) wr.getParameter("id");
		String pass = (String) wr.getParameter("pass");

		Map data = new HashMap<>();
		data.put("id", id);
		data.put("pass", pass);

		Map log = Emplyoee.loginck(data);
		wr.setAttribute("log", log, wr.SCOPE_SESSION);
		
		if (log != null) {
			// 중복 로그인 막기 =================================================
			if(sessions.containsKey(id)) {
				sessions.get(id).invalidate();
				Map mg = new HashMap<>();
				mg.put("mode", "overlap");
				socketService.sendAll(mg);
			}
			sessions.put(id, session);
			
			
			Map one = Emplyoee.getEmployee(id);
			wr.setAttribute("auth", true, wr.SCOPE_SESSION);
			wr.setAttribute("id", id, wr.SCOPE_SESSION);
			wr.setAttribute("one", one, wr.SCOPE_SESSION);
			
			Map msg = new HashMap<>();
			msg.put("mode", "login");
			msg.put("actor", one);
			socketService.sendAll(msg);// 모든 사용자에게 요걸 보내달라
			/*socketService.sendOne(msg, "em1046");*/
			System.out.println(one);

			return "redirect:/";
		} else {
			map.put("err", "on");
			return "index";
		}
	}
		// 로그아웃
		@RequestMapping("/logout.do")
		public String logoutHandle(@SessionAttribute String id, HttpSession session) {
		
		sessions.remove(id);
		session.invalidate();
		System.out.println("로그아웃 완료");
		return "redirect:/";
	}
}
