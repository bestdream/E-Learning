package com.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.user.entity.User;
import com.controller.user.service.UserService;

@Controller
@RequestMapping("user")
public class LoginController {

	@Resource(name="userService")
	private UserService userService;
	
	private final String PATH="/user";
	
	@RequestMapping("/login.html")
	public String login(User user, HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		String url = PATH+"/login";
		if(user.getUsername()!=null){
			url = "";
		}
		return url;
		//userService.login(user, request, response);
	}
}
