package br.com.app.login.credenciais;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginAWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("UUID_STRING", (String) req.getParameter("UUID_STRING")); 
		req.setAttribute("AMAZON_ACCESS_KEY", (String) req.getParameter("AMAZON_ACCESS_KEY")); 
		req.setAttribute("AMAZON_SECRET_KEY", (String) req.getParameter("AMAZON_SECRET_KEY")); 
		req.setAttribute("S3_BUCKET_NAME", (String) req.getParameter("S3_BUCKET_NAME")); 
		req.setAttribute("ZENCODER_API_KEY", (String) req.getParameter("ZENCODER_API_KEY")); 
		RequestDispatcher rd = req.getRequestDispatcher("videoraw.jsp");
		rd.include(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
