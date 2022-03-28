package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelUsuario;

import java.io.IOException;

import dao.DAOLoginRepository;

@WebServlet(urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();

    public ServletLogin() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
		redirecionar.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		try {
			if (!login.isEmpty() && login != null && !password.isEmpty() && password != null) {
				ModelUsuario modelUsuario = new ModelUsuario();
				modelUsuario.setLogin(login);
				modelUsuario.setPassword(password);
				
				if (daoLoginRepository.validarAutenticacao(modelUsuario)) {
					request.getSession().setAttribute(login, modelUsuario.getLogin());
					
					RequestDispatcher redirecionar = request.getRequestDispatcher("principal/quizz.jsp");
					redirecionar.forward(request, response);
				} else {
					RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", "Informe o login e senha corretamente!");
					redirecionar.forward(request, response);	
				}
				
				
				
				
			} else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Informe o login e senha corretamente!");
				redirecionar.forward(request, response);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Ocorreu um erro! Contate os administradores!");
			redirecionar.forward(request, response);
		}
		
	}

}
