package org.openjfx.MarvenProject.model.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openjfx.MarvenProject.Entities.Student;

public class StudentRepository extends Conexao {
	
	private Student student;

	public StudentRepository(Student student) {
		this.student = student;
	}
	
	public StudentRepository() {
		
	};
	
	public Boolean verificandoEntidade() {
	
		if (student != null )
			return true;
		 
		return false;
	}
	
	public boolean cadastrarEstudante() {
		
		try {
				super.abreConexao();
				statment = conexao.createStatement();
				String sql = "INSERT INTO tb_estudante(matricula, nome) values"
						+ "('"+student.getMatricula()+"','"+student.getNome()+"')";
				
				System.out.println(sql);
				statment.execute(sql);
				super.fecharConexao();
				return true;
				}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Student buscarEstudanteMatricula(Long matricula) throws SQLException{
		
		try {
			 super.abreConexao();
			 statment = conexao.createStatement();
			 String sql = "SELECT * FROM tb_estudante where matricula =" + matricula;
			 System.out.println(sql);
			 
			 rs = statment.executeQuery(sql);
			 
			
			 
			 if(rs.next()) {
				 Student studentEncontado = new Student();
				 studentEncontado.setMatricula(rs.getLong("matricula"));
				 studentEncontado.setNome(rs.getString("nome"));
				 return studentEncontado;
			}
			 else {
				 return null;
			 }
			}
		catch(Exception e) {
				 e.printStackTrace();
				 return null;
			 }
		finally {
			rs.close();
			super.fecharConexao();
		}
	}
	
	public Student buscarEstudanteNome(String name) throws SQLException{
		
		try {
			super.abreConexao();
			statment = conexao.createStatement();
			String sql = "SELECT * FROM tb_estudante where nome = '"+name+"'";
			System.out.println(sql);
			
			rs = statment.executeQuery(sql);
			
			if (rs.next()) {
				Student studentEncontrado = new Student();
				studentEncontrado.setMatricula(rs.getLong("matricula"));
				studentEncontrado.setNome(rs.getString("nome"));
				return studentEncontrado;
			}
			else {
				return null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
			
		}
		finally {
			rs.close();
			super.fecharConexao();
		}
	}
	
	public List<Student> buscarStudent(){
		
		try {
			super.abreConexao();
			statment = conexao.createStatement();
			String sql = "SELECT * FROM tb_estudante";
			System.out.println(sql);
			
			rs = statment.executeQuery(sql);
			
			Student studentEcontrado = null;
			List<Student> students = new ArrayList<>();
			while (rs.next()) {
				studentEcontrado = new Student();
				studentEcontrado.setMatricula(rs.getLong("matricula"));
				studentEcontrado.setNome(rs.getString("nome"));
				students.add(studentEcontrado);
				}
			rs.close();
			super.fecharConexao();
			return students;
		}
	
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

	


