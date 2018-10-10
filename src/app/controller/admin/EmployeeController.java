package app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	/*@PostMapping("/add.do")
	public String addPostHandle() {
		
		
		return null;
	}*/
}
