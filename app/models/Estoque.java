package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.Required;

@Entity
public class Estoque {

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private Long quantidade;
	
	@ManyToOne
	private ItemProduto itemproduto;
	
	public static Finder<Long, Estoque> find = new Finder<Long,Estoque>(Estoque.class);

}
