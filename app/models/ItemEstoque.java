package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

import play.data.validation.Constraints.Required;

@Entity
public class ItemEstoque {

	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	public Long quantidade;

	@ManyToOne
	public Produto produto;
	
	public static Finder<Long, ItemEstoque> find = new Finder<Long,ItemEstoque>(ItemEstoque.class);
}