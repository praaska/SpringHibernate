package org.haritha.learning.controller;

import org.haritha.learning.command.LoginBean;
import org.haritha.learning.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	
	    public ModelAndView displayLogin()
	
	    {	
		    System.out.println("In login page");
	        ModelAndView model = new ModelAndView("LoginPage");
	        LoginBean loginBean = new LoginBean();
	        model.addObject("loginBean", loginBean);
	        return model;
	    }

	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") LoginBean login)
	{
		ModelAndView model= null;
		boolean isValidUser;
		System.out.println("in controller");
		try{
		isValidUser=loginService.isValidUser(login.getUsername(), login.getPassword());
		}
		catch(Exception e){
			model=new ModelAndView("LoginPage");
			model.addObject("errorMessage", "Invalid Credentials. Your username or password is incorrect.");
			return model;
		}
		
		 	model=new ModelAndView("redirect:/addLoadForm.do");
				
		
		return model;

	}

}
