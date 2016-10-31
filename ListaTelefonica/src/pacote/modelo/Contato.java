package pacote.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	@Column
	private String telefone;
	@Column
	private String endereco;
	@Column
	private String email;
	
	
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Contato(String nome, String telefone) {
		// TODO Auto-generated constructor stub
		setNome(nome);
		setTelefone(telefone);
	}
	
	public Contato(int id, String nome, String telefone) {
		// TODO Auto-generated constructor stub
		setId(id);
		setNome(nome);
		setTelefone(telefone);
	}
	
	
	public Contato(String nome, String telefone, String endereco, String email) {
		// TODO Auto-generated constructor stub
		setNome(nome);
		setTelefone(telefone);
		setEndereco(endereco);
		setEmail(email);
	}
    
	

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", email="
				+ email + "]";
	}


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}
