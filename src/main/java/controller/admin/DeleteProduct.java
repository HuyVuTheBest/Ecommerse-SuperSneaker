package controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dao.DAO;

@WebServlet(urlPatterns="/RemoveProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	        HttpSession session = request.getSession(false);
			User user = (User)session.getAttribute("account");
			if(user.getRole()!="Customer") {
				 String id = request.getParameter("pid");
			        DAO dao = new DAO();
			        boolean isSuccess = dao.RemoveProductById(Integer.parseInt(id));
			        if (isSuccess) {
			            response.sendRedirect("ProductManager?success");
			        } else {
			            response.sendRedirect("ProductManager?success");
			        }	
			}else {
				  response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			        response.setContentType("text/plain");
			        response.getWriter().write("Page Not Found");
			}
	        
	        
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	    }
}
