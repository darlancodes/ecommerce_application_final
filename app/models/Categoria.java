package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.Required;

@Entity
public class Categoria extends Model {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private String none;
	
	@OneToMany(mappedBy="categoria")
	private List<Produto> Produtos = new ArrayList<>();
	
	public static Finder<Long, Categoria> find = new Finder<Long,Categoria>(Categoria.class);

}
