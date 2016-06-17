package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.Required;

@Entity
public class Carrinho extends Model{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy="carrinho")
	private List<ItemProduto> itemproduto = new ArrayList<>();
	
	@Required
	private int quantidade;
	
	@OneToOne(mappedBy="carrinho")
	private Cliente cliente;
	
	
	public static Finder<Long, Carrinho> find = new Finder<Long,Carrinho>(Carrinho.class);

}
