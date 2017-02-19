package packageV2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.serviceImpl;

@WebServlet("/ToDisplayList")
public class ToDisplayList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDto user = new UserDto();
		user.username = request.getParameter("Username");
		if (user.username.isEmpty()) { // another jsp saying username is empty
			request.setAttribute("error", "username is empty");
			System.out.println("username is empty");
			String destination = "error.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request, response);
		}

		serviceImpl service = new serviceImpl();

		try {

			java.util.List<String> results = service.addUser(user);

			request.setAttribute("added", results);
			System.out.println("Username was unique, u received a wand");
			String destination = "signUpList.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request, response);

		} catch (Exception e) {
			// System.out.println("duplicate user");
			System.out.println(e);
			request.setAttribute("error", "duplicate user");
			System.out.println("duplicate user");
			String destination = "error.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			rd.forward(request, response);

		}

	}
}
