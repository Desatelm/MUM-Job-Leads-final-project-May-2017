package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Like;
import model.User;
import service.LikeService;

/**
 * Servlet implementation class LikePost
 */
@WebServlet("/LikePost")
public class LikePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LikePost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User loginUser = (User) sess.getAttribute("loginUSer");
		int postId = Integer.parseInt(request.getParameter("postId"));
		Date timestamp = new Timestamp(new Date().getTime());
		Like like = new Like();
		like.setUserId(loginUser.getUserId());
		like.setPostId(postId);
		like.setDateCreated(timestamp);
		like.setDateUpdated(timestamp);
		LikeService service = new LikeService();
		List<Like> alreadyLiked = service.getLikeByUserIdAndPostId(loginUser.getUserId(), postId);
		if (alreadyLiked.isEmpty()) {
			if (service.saveLike(like) != 0) {
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}
		} else {
			if (new LikeService().deleteLikeByUserIdAndPostID(loginUser.getUserId(), postId) != 0) {
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}
		}

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
