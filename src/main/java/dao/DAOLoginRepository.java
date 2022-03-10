package dao;

import java.sql.Connection;

import connection.SingleConnectionBanco;

public class DAOLoginRepository {
	private Connection connection;
	
	public DAOLoginRepository () {
		connection = SingleConnectionBanco.getConnection();
	}
	
	public boolean validarAutenticacao () {
		return true;
	}

}
