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
	
	@Required
	@ManyToOne
	private Endereco endereco;
	
	
	
}
