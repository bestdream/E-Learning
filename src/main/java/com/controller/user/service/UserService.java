package com.controller.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.user.entity.User;

public interface UserService {
	
	/**
	 * 登录
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String login(User user, HttpServletRequest request, HttpServletResponse response)throws Exception;

	/**
	 * 添加用户
	 * @param user
	 * @param request
	 * @throws Exception
	 */
	public void addUser(User user, HttpServletRequest request)throws Exception;

	/**
	 * 用户信息变更
	 * @param user
	 * @param request
	 * @throws Exception
	 */
	public void modifyUser(User user, HttpServletRequest request)throws Exception;
}
