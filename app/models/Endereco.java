package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.*;

@Entity
public class Endereco {

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private String Rua;
	
	@Required
	private String Cidade;
	
	@Required
	private String Estado;
	
	@Required
	private String CEP;
	
	@OneToMany(mappedBy="endereco")
	private Cliente cliente;
	
	@OneToMany(mappedBy="endereco")
	private Administrador administrador;
	
	
	
	public static Finder<Long, Endereco> find = new Finder<Long,Endereco>(Endereco.class);
	
	
}
