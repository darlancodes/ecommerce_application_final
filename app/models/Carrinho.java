package models;

import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.Required;

@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private ItemProduto item;
	

	private int quantidade;
	
	@OneToOne(mappedBy="carrinho")
	private Cliente cliente;
	
	public static Finder<Long, Carrinho> find = new Finder<Long,Carrinho>(Carrinho.class);

}
