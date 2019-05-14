package com.login;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.service.RegisterService;
import com.register.view.RegisterView;

@Controller
public class RegisterController {
	@RequestMapping("/registration")
	public ModelAndView registeruser(HttpServletRequest req,HttpServletResponse res)
	
	{
		ModelAndView mv = new ModelAndView();
		
		
			mv.setViewName("register.jsp");
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView adduser(HttpServletRequest req,HttpServletResponse res)
	
	{
		ModelAndView mv = new ModelAndView();
		
		 
		RegisterView rv = new RegisterView();
		rv.setID(req.getParameter("ID"));
		rv.setFirst_Name(req.getParameter("First_Name"));
		rv.setLast_Name(req.getParameter("Last_Name"));
		//rv.setDOB(req.getDateHeader("DOB"));
		//rv.setDOB(DateFormatter.format(req.getParameter("DOB")));
		//iirv.setDate_of_joining(req.getParameter("Date_of_joining"));
		rv.setSalary(Integer.parseInt(req.getParameter("Salary")));
		rv.setflag(req.getParameter("flag"));
		
		RegisterService rs = new RegisterService();
		rs.register(rv);
		
			mv.setViewName("index.jsp");
		
		return mv;
	}

}

	