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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}


	public List<Carrinho> getCarrinho() {
		return carrinho;
	}


	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}

	

}




