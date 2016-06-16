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
	
	
}




