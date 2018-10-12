package app.controller.admin;

import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import app.model.EmplyoeeDao;
import app.service.SocketService;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

	@Autowired
	SocketService socketService;
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
	
}
