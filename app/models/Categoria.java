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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNone() {
		return none;
	}

	public void setNone(String none) {
		this.none = none;
	}

	public List<Produto> getProdutos() {
		return Produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		Produtos = produtos;
	}

	
}
