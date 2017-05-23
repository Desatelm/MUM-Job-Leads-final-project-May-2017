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
import model.Comment;
import model.User;
import service.CommentService;

/**
 * Servlet implementation class CreateComment
 */
@WebServlet("/CreateComment")
public class CreateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateComment() {
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
		Comment comm = new Comment();
		CommentService service = new CommentService();
		HttpSession sess = request.getSession();
		String comment = request.getParameter("comment");
		int postId = Integer.parseInt(request.getParameter("postId"));
		User user = (User) sess.getAttribute("loginUser");
		if (user != null) {
			comm.setUserId(user.getUserId());
			comm.setPostId(postId);
			comm.setComment(comment);
			Date in = new Date();
			LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
			Date dateCreated = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
			comm.setDateCreated(dateCreated);
			comm.setDateUpdated(dateCreated);
			if (service.saveComment(comm) != 0) {
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.forward(request, response);
			}
		} else {
			request.setAttribute("postingError", "There was an error in commenting.");
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		}
	}

}
