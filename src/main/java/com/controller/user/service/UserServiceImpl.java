package com.controller.user.service;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.controller.base.BaseDaoImpl;
import com.controller.user.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="baseDao")
	private BaseDaoImpl baseDao;
	
	@Override
	public String login(User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String hql = "from User where username='admin' and password='1'";
		User oldUser = (User) baseDao.find(hql);
		System.out.println(oldUser.getUsername());
		return null;
	}

	@Override
	public void addUser(User user, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(User user, HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
