package org.openjfx.MarvenProject.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	
	private String url = "jdbc:postgresql://localhost:5432/db_estudante";
	private String username = "postgres";
	private String password = "1234";
	private String driver = "org.postgresql.Driver";
	
	Connection conexao;
	Statement statment;
	ResultSet rs;
	
	protected Connection abreConexao() {
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, username, password);
			return conexao;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected Boolean  fecharConexao() {
		
		try {
			conexao.close();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean verificarConexao() {
		if (conexao != null ) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
