package com.jt.validation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.validation.pojo.UserLogin;
import com.jt.validation.repositary.*;

@Controller
public class validController {
	@Autowired
	LoginRepository rr;
	
@RequestMapping("/")
public String show()
{
	return "Login";
}
@PostMapping("/xyz")
public String xx(@ModelAttribute @Valid  UserLogin u,BindingResult result)
{
		
		 if(result.hasErrors()) {
		  System.err.println(result.getAllErrors().get(0).getDefaultMessage()); }
		 
	UserLogin uu=rr.findByNameAndPassword(u.getName(),u.getPassword());
	if(uu!=null)
		return "success";
	else
		return "failed";	
	
}

}
