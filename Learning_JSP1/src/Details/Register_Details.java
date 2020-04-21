package Details;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Details_p.FetchData;
import Details_p.Details_DAO;
import Details_p.Details_Implements;

@WebServlet("/Register_Details")
public class Register_Details extends HttpServlet {
	FetchData fetchData = null;
	
	private static final long serialVersionUID = 1L;
   
    public Register_Details() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Details_DAO obj_Dao = new Details_Implements();
		String uname=request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Long mobileno = Long.parseLong(request.getParameter("mobileno"));
		
		fetchData = new FetchData();
		fetchData.setUname(uname);
		fetchData.setPassword(password);
		fetchData.setEmail(email);
		fetchData.setMobileno(mobileno);
		
		String addUserdetails = obj_Dao.addUserDeatails(fetchData);
		
		if(addUserdetails !=null)
		{
		request.setAttribute("obj", fetchData);
		RequestDispatcher rd = request.getRequestDispatcher("/Register_suc.jsp");
		rd.forward(request,response);
	
		}
		else 
		{
			request.setAttribute("msg", "Please Check ur details ");
			RequestDispatcher rdq = request.getRequestDispatcher("/Registration_error.jsp");
			rdq.forward(request, response);
	}

		doGet(request, response);
	}

}
