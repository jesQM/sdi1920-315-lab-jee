package com.uniovi.sdi.complementario3.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uniovi.sdi.complementario3.Comment;
import com.uniovi.sdi.complementario3.CommentsDatabase;

/**
 * Servlet implementation class CreateNewComment
 */
@WebServlet("/newComment")
public class CreateNewComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewComment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hi " + request.getSession().getAttribute("username") + " u commented " + request.getParameter("content"));
		
		CommentsDatabase db = new CommentsDatabase();
		db.setNewComment(new Comment( (String) request.getSession().getAttribute("username"), request.getParameter("content")));
		response.sendRedirect(request.getContextPath() + "/complementario3/blogView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
