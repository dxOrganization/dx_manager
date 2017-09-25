package com.thinkgem.jeesite.common.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 跨域的设置
 * @author mzh14
 *
 */
@Component
public class CORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {       
		 
		 String hm = ((HttpServletRequest)req).getMethod();        
		 HttpServletResponse response = (HttpServletResponse) res;               
		 response.setHeader("Access-Control-Allow-Origin", "*");        
		 response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTI ONS, DELETE");        
		response.setHeader("Access-Control-Max-Age", "3600");        
		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");        
		chain.doFilter(req, res);            
		}   
		 public void init(FilterConfig filterConfig) {}    
		 public void destroy() {}  

}
