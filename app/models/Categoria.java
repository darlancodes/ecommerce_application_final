package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.Required;

public class Categoria {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	public String descricao;
	

}
