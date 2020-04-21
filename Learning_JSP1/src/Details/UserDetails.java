package Details;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Details_p.Details_DAO;
import Details_p.Details_Implements;
import Details_p.FetchData;

@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet{

	FetchData fetchData = null;
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Details_DAO obj_dao = new Details_Implements();
		String uname=request.getParameter("username");
		String password = request.getParameter("password");
		
		fetchData = new FetchData();
		fetchData.setUname(uname);
		fetchData.setPassword(password);
	
		FetchData checkUserCredential = obj_dao.checkLoginCredential(uname, password);
		if(checkUserCredential !=null)
		{
		request.setAttribute("msg", "Login_Successfully");
		request.setAttribute("data", fetchData);
		RequestDispatcher rd = request.getRequestDispatcher("/Login_success.jsp");
		rd.forward(request,response);
	
		}
		else 
		{
			
			request.setAttribute("msg", "Please check the details...");
			RequestDispatcher rd = request.getRequestDispatcher("/Login-Error.jsp");
			rd.forward(request, response);
	}

	
	}
}
