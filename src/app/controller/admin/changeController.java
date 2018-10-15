package app.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import app.model.EmplyoeeDao;

@Controller
public class changeController {
	@Autowired
	EmplyoeeDao emplyoee;
	
	@GetMapping("/change.do")
	public String changeGetHandle() {
		System.out.println("================================");
		System.out.println("change에 들어왔어요");
		
		return "change.employee.home";
	}
	
	@PostMapping("/change.do")
	public String changePostHandle(WebRequest wr, ModelMap map) {
		String id = (String)wr.getAttribute("id", wr.SCOPE_SESSION);
		String cpass = (String)wr.getAttribute("pass", wr.SCOPE_SESSION);
		String opass = (String)wr.getParameter("pass");
		String new1pass = (String)wr.getParameter("new1pass");
		String newpass = (String)wr.getParameter("newpass");
		
		System.out.println("기존 비밀번호 : " + cpass);
		
		Map data = new HashMap<>();
		data.put("id", id);
		data.put("pass", newpass);
		
		System.out.println(data);
		
		/*if(new1pass.equals(newpass)) {
			Map er = new HashMap<>();
			er.put("err1", "on");
			return "change.employee.home";
		}else*/
		if(cpass.equals(opass)) {
			int c = emplyoee.setchange(data);
			System.out.println(data);
		
			
			return "redirect:/";
		} else {
			map.put("err", "on");
			return "change.employee.home";
		}
	}
}
