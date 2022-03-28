package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionBanco;
import model.ModelUsuario;

public class DAOLoginRepository {
	private Connection connection;
	
	public DAOLoginRepository () {
		connection = SingleConnectionBanco.getConnection();
	}
	
	public boolean validarAutenticacao (ModelUsuario modelUsuario) throws Exception {
		String sql = "Select * from model_usuario where upper(login) == upper(?) and upper(senha) = upper(?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, modelUsuario.getLogin());
		statement.setString(2, modelUsuario.getPassword());
		
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	

}
