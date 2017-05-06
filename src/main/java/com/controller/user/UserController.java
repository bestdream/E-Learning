package com.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.user.entity.User;
import com.controller.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/addUser.html")
	public void addUser(User user, HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		userService.addUser(user, request);
	}
	
	@RequestMapping("/modifyUser.html")
	public void modifyUser(User user, HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		userService.modifyUser(user, request);
	}
}
