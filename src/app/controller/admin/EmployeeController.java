package app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String addPostHandle(ModelMap map, WebRequest web) {
		String name = web.getParameter("nick");
		String did = web.getParameter("dpart");
		String pid = web.getParameter("pst");
		String joindate = web.getParameter("date");
		
		map.put("id", "em" + Emplyoee.getSequenceVal());
		map.put("pass", "1111");
		map.put("name", name);
		map.put("did", did);
		map.put("pid", pid);
		map.put("joindate", joindate);
		
		int e = Emplyoee.addemployee(map);
		System.out.println(e);
		
		return "redirect:/admin/employee/check.do";
	}
	
	@RequestMapping("/check.do")
	public String checkHandle() {
		return "check";
	}
	
	
}
