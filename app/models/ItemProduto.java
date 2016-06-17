package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

import play.data.validation.Constraints.Required;

@Entity
public class ItemProduto extends Model {

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private Long quantidade;

	@Required
	@OneToMany(mappedBy="itemproduto")
	private List<Produto> produto = new ArrayList<>();

	
	@ManyToMany
	private List<Carrinho> carrinho = new ArrayList<>();
	
	
	public static Finder<Long, ItemProduto> find = new Finder<Long,ItemProduto>(ItemProduto.class);
}




