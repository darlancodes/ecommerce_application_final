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
	public Long id;
	
	@Required
	public String nome;
	
	@OneToMany(mappedBy="categoria")
	public List<Produto> Produtos = new ArrayList<>();
	
	public static Finder<Long, Categoria> find = new Finder<Long,Categoria>(Categoria.class);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return Produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		Produtos = produtos;
	}

	
}
