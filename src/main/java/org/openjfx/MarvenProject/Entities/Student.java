package org.openjfx.MarvenProject.Entities;

public class Student {

	private Long matricula;
	private String nome;
	
	
	public Student(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}


	public Student() {
		super();
	}


	public Long getMatricula() {
		return matricula;
	}


	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "Student [matricula=" + matricula + ", nome=" + nome + "]";
	}
	
	
	
	
}
