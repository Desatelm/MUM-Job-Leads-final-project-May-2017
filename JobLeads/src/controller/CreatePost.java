package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Comment;
import model.Post;
import model.PostDetail;
import model.User;
import service.CommentService;
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
			Date timestamp = new Timestamp(new Date().getTime());
			post.setDateCreated(timestamp);
			post.setDateUpdated(timestamp);
			int result = service.savePost(post);
			if (result != 0) {
				PrintWriter out = response.getWriter();

				List<Comment> allcomments = new CommentService().getCommentsByUserId(user.getUserId());
				PostDetail postDetails = new PostDetail(result, "", "", timestamp, leads, user.getCity(), null);
				String JSONposts;
				JSONposts = new Gson().toJson(postDetails);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(JSONposts);

				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}
		} else {
			request.setAttribute("postingError", "There was an error in posting.");
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		}
	}

}
