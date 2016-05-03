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
	public Long codigoBarras;
	
	@Required
	public String nome;
	@Required
	public String categoria;
	
	public String descricao; 
	public byte[] foto;
	
	public static Finder<Long, Produto> find = new Finder<Long,Produto>(Produto.class);
	
}
