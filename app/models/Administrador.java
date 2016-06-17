package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.*;

@Entity
public class Administrador extends Model{

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private String login;
	
	@Required
	private String matricula;
	
	@Required
	private String password;
	
	@Required
	private String email;
	
	@ManyToOne
	private Endereco endereco;
	
	public static Finder<Long, Administrador> find = new Finder<Long,Administrador>(Administrador.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	
	
	
}
