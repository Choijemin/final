package app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class changeController {

	@GetMapping("/change.do")
	public String changeHandle() {
		
		
		return "change";
	}
}
