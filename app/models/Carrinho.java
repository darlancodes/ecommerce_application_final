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
	private List<Produto> produto = new ArrayList<>();
	
	@Required
	private int quantidade;
	
	@OneToOne(mappedBy="carrinho")
	private Cliente cliente;
	
	
	public static Finder<Long, Carrinho> find = new Finder<Long,Carrinho>(Carrinho.class);


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Produto> getItemproduto() {
		return produto;
	}


	public void setItemproduto(List<Produto> itemproduto) {
		this.produto = itemproduto;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
