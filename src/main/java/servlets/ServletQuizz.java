package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelQuizz;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAOLoginRepository;
import dao.DAOQuizzRepository;

@WebServlet(urlPatterns = "/ServletQuizz")
public class ServletQuizz extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DAOQuizzRepository daoQuizzRepository = new DAOQuizzRepository();

    public ServletQuizz() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		 try {
	       	   
	    	   if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarQuizz")) {  		   
	    		   List<ModelQuizz> dadosJsonQuizz = daoQuizzRepository.consultaQuizzList();
	   
	    		   ObjectMapper mapper = new ObjectMapper();
	    		   String json = mapper.writeValueAsString(dadosJsonQuizz);
	    	

	    		   response.setContentType("application/json");
	    		   response.setCharacterEncoding("UTF-8");
	    		   
	    		   
	    		   response.getWriter().write(json);
	    		   
	    		   System.out.println(json);
	    	   }
	    	   
	    	   
	    	   request.getRequestDispatcher("principal/pergunta.jsp").forward(request, response);

	    	   
	       } catch (Exception e) {
	    	   e.printStackTrace();
	    	   request.setAttribute("msg", e.getMessage());
	    	   RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
	    	   redirecionar.forward(request, response);
	    	   
	       }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pergunta = request.getParameter("tituloPergunta");
		String resposta = request.getParameter("textoPergunta");
		
		try {
			ModelQuizz modelQuizz = new ModelQuizz();
			if (pergunta != null && !pergunta.isEmpty() && resposta != null && !resposta.isEmpty()) {
				modelQuizz.setPergunta(pergunta);
				modelQuizz.setResposta(resposta);
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/pergunta.jsp");
				redirecionar.forward(request, response);
			} else {
				RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/pergunta.jsp");
				redirecionar.forward(request, response);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Ocorreu um erro, contate o admistrador!");
			RequestDispatcher redirecionar = request.getRequestDispatcher("/principal/pergunta.jsp");
			redirecionar.forward(request, response);
		}
	}

}
