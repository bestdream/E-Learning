package com.controller.UE;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

@Controller
@RequestMapping("/ued")
public class UEditorController {
	@RequestMapping(value="/config.html")
    public void config(HttpServletRequest request, HttpServletResponse response) {
 
        try {
        	request.setCharacterEncoding( "utf-8" );
    		//response.setHeader("Content-Type" , "application/json");
    		String requesturl = request.getRequestURI();
    		Map map = request.getParameterMap();
    		String rootPath = request.getSession().getServletContext().getRealPath( "/" );
            String exec = new ActionEnter( request, rootPath ).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}
