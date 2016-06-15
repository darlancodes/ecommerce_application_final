package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.*;

@Entity
public class Administrador {

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
	
	@Required
	@OneToMany(mappedBy="adiministrador")
	private Endereco endereco;
	
}
