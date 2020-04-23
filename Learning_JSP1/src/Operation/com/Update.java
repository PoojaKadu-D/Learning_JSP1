package Operation.com;

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

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FetchData fetchData = new FetchData();
		fetchData.setId(Integer.parseInt(request.getParameter("id")));
		fetchData.setUname(request.getParameter("username"));
		fetchData.setPassword(request.getParameter("password"));
		fetchData.setEmail(request.getParameter("email"));
		fetchData.setMobileno(Long.parseLong(request.getParameter("mobileno")));
		
		Details_DAO update_Dao = new Details_Implements();
		boolean updateData=  update_Dao.updateDetailById(fetchData);		
		
		if(updateData) {
			RequestDispatcher rd = request.getRequestDispatcher("/Update_succs.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
