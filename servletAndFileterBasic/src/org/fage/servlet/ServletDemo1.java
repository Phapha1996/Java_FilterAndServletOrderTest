package org.fage.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Servlet开始执行");
		String path = this.getServletContext().getRealPath("/动态图.gif");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		response.setHeader("content-disposition", "attachment;filename="+filename);
		
		InputStream in = null;
		OutputStream out = null;
		
		try{
			
			in = new FileInputStream(path); 
			int len = 0;
			byte buffer[] = new byte[2014];
			out = response.getOutputStream();
			while((len=in.read(buffer))>0){
				out.write(buffer, 0, len);
			}
		}
		finally{
			try{ 
			  if(in!=null){
				in.close();
			      }
	        	}catch(Exception e){
	        		e.printStackTrace();
	        	}
			if(out!=null){
				try{
					out.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
				
			
		}
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
