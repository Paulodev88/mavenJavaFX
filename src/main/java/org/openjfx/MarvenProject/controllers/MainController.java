package org.openjfx.MarvenProject.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.openjfx.MarvenProject.Entities.Student;
import org.openjfx.MarvenProject.model.repository.StudentRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {
	private Student student;
	private StudentRepository sRepository;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNomeB;

    @FXML
    private TextField txtMatriculaB;

    @FXML
    private Label lbResultado;
    
    @FXML
    private Label lbResultadoMatricula;
    
    @FXML
    private TableView<Student> tbStudent;

    @FXML
    private TableColumn<Student, Long> ColumnMatricula;

    @FXML
    private TableColumn<Student, String> ColumnName;
    

    @FXML
    void btBuscaNome(ActionEvent event) {
    	
    	try {
    		sRepository = new StudentRepository();
    		student = new Student();
    		String nome = txtNomeB.getText();
    		student = sRepository.buscarEstudanteNome(nome);
    		
    		if (student != null) {
    			lbResultado.setText(student.toString());
    		}
    		else {
    			lbResultado.setText("Estudante não Encontrado");
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		lbResultado.setText("Houve um erro na busca!!");
    	}
    }

    @FXML
    void btBuscarMatricula(ActionEvent event) {
    	
    	try {
    		sRepository = new StudentRepository();
    		student = new Student();
    		Long matricula = Long.parseLong(txtMatriculaB.getText());
    		student = sRepository.buscarEstudanteMatricula(matricula);
    		
    		if (student != null) {
    			lbResultado.setText(student.toString());
    		}
    		else {
    			lbResultado.setText("Estudante Não Encontrado!");
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		lbResultado.setText("houve um erro na busca!");
    	}
    		
    }

    @FXML
    void btCadastrar(ActionEvent event) {
    	
    	student = new Student();
    	student.setMatricula(Long.parseLong(txtMatricula.getText()));
    	student.setNome(txtNome.getText());
    	System.out.println(student.toString());
    	
    	sRepository = new StudentRepository(student);
    	
    	if (sRepository.cadastrarEstudante()) {
    		lbResultadoMatricula.setText("Aluno Cadastrado!");
    		}
    	else {
    		lbResultadoMatricula.setText("Erro! Aluno não cadastrado!");
    	}
    	
    	

    }
    
   
    @FXML
    void btCarregar(ActionEvent event) {
    	
    	this.carregarEstudante();

    }
    
    public void carregarEstudante() {
    	
    	sRepository = new StudentRepository();
    	List<Student> students = sRepository.buscarStudent();
    	
    	ObservableList<Student> observableStudent = FXCollections.observableArrayList();
    	
    	students.forEach(student ->{
    		observableStudent.add(student);
    	});
    	
    	ColumnMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
    	ColumnName.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	
    	tbStudent.setItems(observableStudent);
    }

    
    @FXML
    void btSair(ActionEvent event) {
    	System.exit(0);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.carregarEstudante();
	}

}
