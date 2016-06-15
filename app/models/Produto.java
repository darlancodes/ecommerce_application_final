package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.avaje.ebean.Model;
import play.data.validation.Constraints.*;

@Entity
public class Produto extends Model{

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private String nome;
	
	@Required
	@ManyToOne
	private Categoria categoria;
	
	@Required
	private double preco;
	
	@Required
	private String descricao; 
	
	@Required
	private byte[] foto;
	
	@ManyToOne
	private ItemProduto itemproduto;
	
	public static Finder<Long, Produto> find = new Finder<Long,Produto>(Produto.class);
	
}
