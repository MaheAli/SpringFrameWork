package com.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.service.LoginService;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView checkuser(HttpServletRequest req,HttpServletResponse res)
	
	{
		ModelAndView mv = new ModelAndView();
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		if(new LoginService().check(uname,pass))
		{
			mv.setViewName("display.jsp");
			mv.addObject("uname" ,uname);
		}
		else 
		{
			mv.setViewName("login.jsp");
		}
		return mv;
	}

}
