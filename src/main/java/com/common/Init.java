package com.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.controller.base.BaseDaoImpl;


public class Init implements InitializingBean,ServletContextAware {

	@Autowired
	private BaseDaoImpl baseDao;
	private ServletContext context;
	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		context.setAttribute("siteName", "在线课程互动平台");
	}

	

}
