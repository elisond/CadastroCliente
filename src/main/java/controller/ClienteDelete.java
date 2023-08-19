package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import dao.ClienteDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ClienteDestroy")
public class ClienteDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ClienteDelete() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		ClienteDao.delete(clienteId);
		
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
	}

}
