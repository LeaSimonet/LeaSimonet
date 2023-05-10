package formation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgeController
 */
@WebServlet("/a")
public class AgeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/formAge.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		// TODO Auto-generated method stub
		if (request.getParameter("age") != null && !request.getParameter("age").isEmpty()) {
			Integer age = Integer.parseInt(request.getParameter("age"));
			request.setAttribute("age", age);

			rd = request.getRequestDispatcher("/WEB-INF/formAge.jsp");
		} else {
			request.setAttribute("erreur", "Il faut un âge");
			rd = request.getRequestDispatcher("/formAge.jsp");
			// Paremètre manquant
		}
		rd.forward(request, response);
	}

}
