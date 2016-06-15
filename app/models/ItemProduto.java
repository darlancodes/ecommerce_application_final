package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

import play.data.validation.Constraints.Required;

@Entity
public class ItemProduto {

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private Long quantidade;

	@Required
	@OneToMany(mappedBy="itemproduto")
	private Produto produto;
	
	@ManyToOne
	private Estoque estoque;
	
	
	public static Finder<Long, ItemProduto> find = new Finder<Long,ItemProduto>(ItemProduto.class);
}