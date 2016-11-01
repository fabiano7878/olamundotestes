package com.arquiteto.olamundo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arquiteto.olamundo.OlaMundo;

/**
 * Servlet implementation class OlaMundoControllerServlet
 */
@WebServlet("/mundo")
public class OlaMundoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OlaMundoControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("olamundo.jsp").forward(request, response);
		
		 String forward="";
	     String action = request.getParameter("action");
	     
	/*	String nome = request.getParameter("nome");
		
		request.setAttribute("nome", nome);
		request.getRequestDispatcher("olamundosucesso.jsp").forward(request, response);*/
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		String nome = request.getParameter("nome");
		
		if(!"".equals(nome)){
			OlaMundo olamundo = new OlaMundo();
			
			nome = nome+""+ olamundo.nome(nome);			
			
			session.setAttribute("nome", nome);
			request.setAttribute("nome", nome);
			
			request.getRequestDispatcher("olamundosucesso.jsp").forward(request, response);
			
		}else if("volta".equals(nome)){
			request.getRequestDispatcher("olamundo.jsp").forward(request, response);
		}else{
			
			nome = "� necess�rio digitar o nome";
			
			request.setAttribute("nome", nome);
			request.getRequestDispatcher("olamundo.jsp").forward(request, response);			
		}
		
	}

}
