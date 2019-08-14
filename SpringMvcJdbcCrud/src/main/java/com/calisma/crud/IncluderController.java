package com.calisma.crud;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IncluderController {

	@RequestMapping(value="/css" , method = RequestMethod.GET)
	public String css() {
		
		return "inc/css";
	}
	
	@RequestMapping(value="/js" , method = RequestMethod.GET)
	public String js() {
		
		return "inc/js";
	}
	
	//footer
		@RequestMapping(value = "/footer" , method = RequestMethod.GET)
		public String footer() {
			
			return "inc/footer";
		}
		
	//sidebar
		@RequestMapping(value = "/sidebar" , method = RequestMethod.GET)
		public String sideBar() {
			
			return "inc/sidebar";
		}
		
		//navbar
		@RequestMapping(value="/navbar" , method = RequestMethod.GET)
		public String navbar() {
			
			return "inc/navbar";
		}
}
