package formation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("prenom"); // renvoi que des String !!
		String ageEnString = request.getParameter("age");
		Integer age = 0;
		if(ageEnString!=null) {
			age=Integer.parseInt(ageEnString);
		}
		response.getWriter().append("<!DOCTYPE html>")
							.append("<html>")
							.append("<head>")
							.append("<meta charset=\"ISO-8859-1\">")
							.append("<title>Formation</title>")
							.append("<body>")
							.append("<h1>Bonjour "+prenom + "Et J'ai :"+age +"</h1>")
							.append("</body>")
							.append("</html>");
	}

	

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
