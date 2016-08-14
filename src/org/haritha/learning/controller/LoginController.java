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
	        ModelAndView model = new ModelAndView("LoginPage");
	        LoginBean loginBean = new LoginBean();
	        model.addObject("loginBean", loginBean);
	        return model;
	    }

	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") LoginBean login)
	{
		ModelAndView model= null;
		System.out.println("in controller");
		boolean isValidUser=loginService.isValidUser(login.getUsername(), login.getPassword());
		if(isValidUser){
			System.out.println("login successful");
		 	model=new ModelAndView("redirect:/addLoadForm.do");
			//return "redirect:/addLoadForm";
		}
		else{
			System.out.println("login failure");
			model=new ModelAndView("LoginPage");
			model.addObject("error", "error");
		}
		
		
		return model;

	}

}
