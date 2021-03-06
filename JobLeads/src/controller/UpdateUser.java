package controller;

import java.io.IOException;
import java.sql.Timestamp;
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

import model.User;
import service.UserProfileService;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		int gen = 0;
		UserProfileService service = new UserProfileService();
		String name = request.getParameter("firstname") + " " + request.getParameter("lastname");
		String gender = request.getParameter("gender");
		if (gender.equals("Female")) {
			gen = 1;
		}
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		int zip = Integer.parseInt(request.getParameter("zip"));
		int birthYear = Integer.parseInt(request.getParameter("birthyear"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Date timestamp = new Timestamp(new Date().getTime());
		user.setName(name);
		user.setGender(gen);
		user.setState(state);
		user.setCity(city);
		user.setStreet(street);
		user.setZip(zip);
		user.setEmail(email);
		user.setBirthYear(birthYear);
		user.setPassword(password);
		user.setDateCreated(timestamp);
		user.setDateUpdated(timestamp);

		if (service.updateUser(user) != 0) {
			HttpSession sess = request.getSession();
			sess.setAttribute("loginUser", user);
			request.setAttribute("signUpError", "");
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("signUpError", "There is an error in updating.");
			RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
			view.forward(request, response);
		}

	}

}
