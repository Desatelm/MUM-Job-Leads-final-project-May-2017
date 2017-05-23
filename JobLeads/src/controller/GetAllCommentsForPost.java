package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Comment;
import model.Like;
import model.User;
import service.CommentService;
import service.LikeService;

/**
 * Servlet implementation class GetAllCommentsForPost
 */
@WebServlet("/GetAllCommentsForPost")
public class GetAllCommentsForPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllCommentsForPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession();
		User loginUser = (User) sess.getAttribute("loginUSer");
		List<Comment> allComments = new CommentService().getCommentsByUserId(loginUser.getUserId());
		String JSONcomments;
		JSONcomments = new Gson().toJson(allComments);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.write(JSONcomments);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
