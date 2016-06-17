package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

import play.data.validation.Constraints.*;

@Entity
public class Cliente extends Model{

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private String nome;
	@Required
	private String password;
	@Required
	private String email;
	
	@Required
	@ManyToOne
	private Endereco endereco;
	
	@OneToOne
	private Carrinho carrinho;
	
	
	public static Finder<Long, Cliente> find = new Finder<Long,Cliente>(Cliente.class);


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Carrinho getCarrinho() {
		return carrinho;
	}


	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	
}




