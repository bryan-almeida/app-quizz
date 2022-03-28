package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnectionBanco;
import model.ModelQuizz;

public class DAOQuizzRepository {
	
private Connection connection;
	
	public DAOQuizzRepository() {
		connection = SingleConnectionBanco.getConnection();
	}
	
	
//	public ModelQuizz gravarQuizz(ModelQuizz modelQuizz) throws Exception {
//		
//			String sql = "insert into model_quizz(pergunta, resposta) values (?, ?);";
//			
//			PreparedStatement preparedSql = connection.prepareStatement(sql);
//			
//			preparedSql.setString(1, modelQuizz.getPergunta());
//			preparedSql.setString(2, modelQuizz.getResposta());
//			
//			preparedSql.execute();
//			connection.commit();
//		
//		
//			
//		
//		return this.consultarQuizz(modelQuizz.getPergunta());
//	}
	
	public List<ModelQuizz> consultaQuizzList() throws Exception {
		List<ModelQuizz> retorno = new ArrayList<ModelQuizz>();
		
		String sql = "select pergunta, resposta from model_quizz";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			ModelQuizz modelQuizz = new ModelQuizz();
			modelQuizz.setPergunta(resultado.getString("pergunta"));
			modelQuizz.setResposta(resultado.getString("resposta"));
			
			retorno.add(modelQuizz);
		}
		
		return retorno;
		
	}
	

	public boolean validarQuizz (String pergunta) throws Exception {
		String sql = "select count(1) > 0 as existe from model_quizz where upper(pergunta) = upper('"+pergunta+"');";
		PreparedStatement preparedSql = connection.prepareStatement(sql);
		
		ResultSet resultado = preparedSql.executeQuery();
		
		resultado.next();
		return resultado.getBoolean("existe");
				
		
	}
	
	public void deletarQuizz (String pergunta) throws Exception {
		String sql = "DELETE FROM model_quizz WHERE pergunta=?";
		PreparedStatement prepareSql = connection.prepareStatement(sql);
		
		prepareSql.setString(1, pergunta);
		
		
		prepareSql.executeUpdate();
		
		connection.commit();
		
		
}

}
