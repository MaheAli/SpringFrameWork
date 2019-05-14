package com.login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.service.RegisterService;
import com.login.service.UpdateService;
import com.register.view.RegisterView;

@Controller
public class UpdateController {
	
	@RequestMapping("/update")
	public ModelAndView updateuser(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
	
	RegisterView rv = new RegisterView();
	//System.out.println(req.getParameter("id-txt"));
	 
	rv.setFirst_Name(req.getParameter("First_Name"));
	rv.setLast_Name(req.getParameter("Last_Name"));
	rv.setSalary(Integer.parseInt(req.getParameter("Salary")));
	rv.setID(req.getParameter("ID"));
	
	UpdateService rs = new UpdateService();
	rs.update(rv);
	
		mv.setViewName("display.jsp");
	return mv;
}
}
