package dev.syntax.step02servletprocess;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L ;
	
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init called") ;
        super.init() ;
    }
    
    public void destroy() {
        System.out.println("destroy called") ;
        super.destroy() ;
    }
    
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service called") ;
        super.service(request, response) ;
    }
    
    protected void doGet(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet called") ;
    }
    
}
