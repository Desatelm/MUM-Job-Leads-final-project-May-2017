package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;
import model.User;
import service.PostService;

/**
 * Servlet implementation class CreatePost
 */
@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		int pType = 2;
		PostService service = new PostService();
		HttpSession sess = request.getSession();
		String leads = request.getParameter("postlead");
		String seeks = request.getParameter("postseek");
		User user = (User) sess.getAttribute("loginUser");
		if (user != null) {
			post.setUserId(user.getUserId());
			if (seeks.equals("") && !leads.equals("")) {
				pType = 0;
				post.setPost(leads);
			} else if (!seeks.equals("") && leads.equals("")) {
				pType = 1;
				post.setPost(seeks);
			}
			post.setPostType(pType);
			Date in = new Date();
			LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
			Date dateCreated = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
			post.setDateCreated(dateCreated);
			post.setDateUpdated(dateCreated);
			if (service.savePost(post) != 0) {
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}
		} else {
			request.setAttribute("postingError", "There was an error in posting.");
			RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
			view.forward(request, response);
		}
	}

}
