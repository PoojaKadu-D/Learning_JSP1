package Details;

import java.io.IOException;
import java.util.ArrayList;

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

	
	
	private static final long serialVersionUID = 1L;
	
	public UserDetails() {
		
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Details_DAO obj_dao = new Details_Implements();
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		//FetchData fetchData =null;
		/*
		 * fetchData = new FetchData(); fetchData.setUname(uname);
		 * fetchData.setPassword(password);
		 */
		
		FetchData fetchData = obj_dao.checkLoginCredential(username, password);
		
		ArrayList<FetchData> list = obj_dao.getAllDetails();
//		System.out.println(list);
		if(fetchData !=null)
		{
		request.setAttribute("data", fetchData);
		request.setAttribute("userList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/Login_success.jsp");
		rd.forward(request,response);
	
		}
		else 
		{
			
			request.setAttribute("msg", "Please check the details...");
			RequestDispatcher rd = request.getRequestDispatcher("/Login-Error.jsp");
			rd.forward(request, response);
	}

	doGet(request, response);
	
}
}
