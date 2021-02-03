package org.zerock.common.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleController
 */

//new 사용 불가능 하게 abstract로 추상클래스를 만듦
public abstract class MultiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected Map<String, Method> methodMap;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiController() {
        super();
        
        methodMap = new HashMap<>();
        
        //                       클래스의 매소드를 얻어온다.
        Method[] methods = this.getClass().getDeclaredMethods();
        
        for (Method method : methods) {
        //					매소드의 이름	  ,	 매소드 값(GET,POST)
			methodMap.put(method.getName(), method);
		}
        
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SampleController run............");
	
		String path = request.getPathInfo().substring(1);
		System.out.println(path);
		String method = request.getMethod();
		System.out.println(method);
		
		String oper = path+method;
		
		String dest = null;
		
		Method targetMethod = methodMap.get(oper);
		
		if(targetMethod != null) {
			try {
				dest = (String)targetMethod.invoke(this, request, response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(dest != null && dest.startsWith("re:")) {
			response.sendRedirect(dest.substring(3));
		}else {
			request.getRequestDispatcher("/WEB-INF/"+dest+".jsp").forward(request, response);
		}
	}
	
	protected int getInt(HttpServletRequest req, String name , int defaultValue) {
		
		try {
			
			String value = req.getParameter(name);
			
			if(value== null || value.trim().length() == 0) {
				return defaultValue;
			}
			
			
			return Integer.parseInt(value);
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}
}