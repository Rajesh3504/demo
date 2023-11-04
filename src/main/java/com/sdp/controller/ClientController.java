package com.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.model.User;
import com.sdp.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{
	
	@Autowired
	private UserService userService;
	@GetMapping("/")
    public ModelAndView index()
    {
   	 ModelAndView mv=new ModelAndView("signlog");
   	 return mv;
    }
	
	
     @GetMapping("Blog")
     public ModelAndView blog()
     {
    	 ModelAndView mv=new ModelAndView("index");
    	 return mv;
     }
     
     
     
     @GetMapping("categories")
     public ModelAndView categories()
     {
    	 ModelAndView mv=new ModelAndView("categories");
    	 return mv;
     }
     
     
     @GetMapping("contact")
     public ModelAndView contact()
     {
    	 ModelAndView mv=new ModelAndView("contact");
    	 return mv;
     }
     
     
     @GetMapping("single-result")
     public ModelAndView singleresult()
     {
    	 ModelAndView mv=new ModelAndView("single-result");
    	 return mv;
     }
     
     @GetMapping("single-post")
     public ModelAndView singlepost()
     {
    	 ModelAndView mv=new ModelAndView("single-post");
    	 return mv;
     }
     
     
     @PostMapping("userreg")
 	public ModelAndView userreg(HttpServletRequest request)
 	{
 		ModelAndView mv = new ModelAndView();
 		String msg=null;
 		try
 		{
 			String name = request.getParameter("name");
 			String email = request.getParameter("email");
 			String pwd = request.getParameter("pwd");
 			
 			User user=new User();
 			user.setName(name);;
 			user.setEmail(email);
 			user.setPassword(pwd);
 			msg=userService.adduser(user);
 			mv.setViewName("signlog");
 			mv.addObject("message",msg);
 		}
 		catch (Exception e) 
 		{
 			mv.setViewName("signlog");
 			msg=e.getMessage();
 			mv.addObject("message",msg);
 		}
 		return mv;
 	}
 	
 	@PostMapping("checkuserlogin")
 	public ModelAndView checkuserlogin(HttpServletRequest request)
 	{
 		ModelAndView mv = new ModelAndView();
 		String email=request.getParameter("email");
 		String pwd=request.getParameter("pwd");
 		
 		User u=userService.checkuserlogin(email, pwd);
 		if(u!=null)
 		{
 			HttpSession session =request.getSession();
 			session.setAttribute("uid",u.getId());
 			session.setAttribute("uname", u.getName());
 			mv.setViewName("index");
 		}
 		else
 		{
 			mv.setViewName("signlog");
 			mv.addObject("message","Login Failed");
 		}
 		return mv;
 	}
     
}
