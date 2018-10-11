package app.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import app.model.EmplyoeeDao;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

	@Autowired
	EmplyoeeDao Emplyoee; 
		
	@GetMapping("/add.do")
	public String addGetHandle(ModelMap map) {
		System.out.println("어서오시고");
		
		map.put("depart", Emplyoee.Alldepart());
		map.put("position", Emplyoee.Allposition());
		
		System.out.println(map);
		
		return "admin.employee.add";
	}
	@PostMapping("/add.do")
	public String addPostHandle(ModelMap map, @RequestParam Map param) {
		
		System.out.println(param);
		String nid = Emplyoee.getSequenceVal(); 
		param.put("id", nid);
	
		try {
			int t = Emplyoee.addemployee(param);
			map.put("employee", param);
			return "admin.employee.addresult";
			
		}catch (Exception e) {
			e.printStackTrace();
			map.put("err", "on");
			map.put("depart", Emplyoee.Alldepart());
			map.put("position", Emplyoee.Allposition());
			return "admin.employee.add";
		}
	}
	
	
	@RequestMapping("/index.do")
	public String GetindexHandle() {
		System.out.println("index에 들어왔어요");
		return "index";
	}
	
	@PostMapping("/login.do")
	public String loginHandle(WebRequest wr, ModelMap map, HttpSession session) {
		System.out.println("======================================");
		System.out.println("login.do에 들어왔어요");
		String id = (String)wr.getParameter("id");
		String pass = (String)wr.getParameter("pass");
		
		map.put("id", id);
		map.put("pass", pass);
		
		Map log = Emplyoee.loginck(map);
		if(log != null) {
			session.setAttribute("auth", true);
			wr.setAttribute("id", id, WebRequest.SCOPE_SESSION);
			return "redirect:/admin/employee/index.do";
		} else {
			map.put("err", "on");
			return "index";
		}
		
		
	}
}
