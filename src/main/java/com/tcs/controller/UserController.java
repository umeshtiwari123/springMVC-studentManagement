package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.dto.User;
import com.tcs.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("LoginPage")
	public ModelAndView loginUser()
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("LoginPageOpen.jsp");
		modelAndView.addObject("User",new User());
		return modelAndView;
	}
	
	@RequestMapping("SignUpPage")
	public ModelAndView signupUser()
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("SignUp.jsp");
		modelAndView.addObject("signupuser",new User());
		return modelAndView;
	}
	
	@RequestMapping("signUpUser")
	public ModelAndView saveUser(@ModelAttribute User user)
	{
		userService.saveUser(user);
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.setViewName("LoginPageOpen.jsp");
		modelAndView.addObject("User",new User());
		return modelAndView;
	}
	
	@RequestMapping("saveUser")
	public ModelAndView loginUser(@ModelAttribute User user)
	{
		ModelAndView modelAndView = new ModelAndView();
		User user2=userService.getUserByEmail(user);
		if(user2!=null)
		{
			modelAndView.setViewName("SignUp.jsp");
			modelAndView.addObject("signupuser",new User());
		}
		else
			modelAndView.setViewName("index.jsp");
		return modelAndView;
	}
	
}
