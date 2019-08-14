package com.calisma.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import props.User;
import util.DB;

@Controller
public class HomeController {

	DB db = new DB();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String login(Model model , @RequestParam("mail") String mail , @RequestParam("pass") String pass, HttpServletRequest req) {
		
		try {
			String query = "SELECT * FROM `login`";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String umail = rs.getString("umail");
				String upass = rs.getString("upass");
		
			
				if(mail.equals(umail) && pass.equals(upass)) {
					req.getSession().setAttribute("userSession", uid);
					req.getSession().setAttribute("userMail", umail);
					req.getSession().setAttribute("userName", uname);
					return "redirect:/dashboard";
					
				}else {
					model.addAttribute("fail" , "Wrong username or password!");
					return "home";
					
				}
			}
		} 
		
		catch (Exception e) {
			System.err.println("Login hatası " + e);
		}
		
		return "redirect:/";
		
	}
	
	// exit call
		@RequestMapping(value="/exit" , method = RequestMethod.GET)
		public String exit(HttpServletRequest req) {
			
			req.getSession().removeAttribute("userSession");
			req.getSession().invalidate(); // tum sessionlari siler
			
			return "redirect:/";
		}
	
}
