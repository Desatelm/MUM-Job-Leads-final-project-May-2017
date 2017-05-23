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

import model.Like;
import model.User;
import service.LikeService;

/**
 * Servlet implementation class GetAllLikesForPost
 */
@WebServlet("/GetAllLikesForPost")
public class GetAllLikesForPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllLikesForPost() {
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
		int postId = Integer.parseInt(request.getParameter("postId"));
		List<Like> allLikes = new LikeService().getLikeByUserIdAndPostId(loginUser.getUserId(), postId);
		String JSONlikes;
		JSONlikes = new Gson().toJson(allLikes);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.write(JSONlikes);
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
