package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

import play.data.validation.Constraints.*;

@Entity
public class Usuario extends Model{

	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	public String usuario;
	@Required
	public String password;
	@Required
	public Boolean tipoUsuario;
	
	public static Finder<Long, Usuario> find = new Finder<Long,Usuario>(Usuario.class);
	
}




