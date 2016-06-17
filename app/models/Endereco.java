package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;
import play.data.validation.Constraints.*;

@Entity
public class Endereco extends Model{

	@Id
	@GeneratedValue
	private Long id;
	
	@Required
	private String Rua;
	
	@Required
	private String Cidade;
	
	@Required
	private String Estado;
	
	@Required
	private String CEP;
	
	@OneToMany(mappedBy="endereco")
	private List<Cliente> cliente = new ArrayList<>();
	
	@OneToMany(mappedBy="endereco")
	private List<Administrador> administrador = new ArrayList<>();
	
	
	public static Finder<Long, Endereco> find = new Finder<Long,Endereco>(Endereco.class);


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRua() {
		return Rua;
	}


	public void setRua(String rua) {
		Rua = rua;
	}


	public String getCidade() {
		return Cidade;
	}


	public void setCidade(String cidade) {
		Cidade = cidade;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public String getCEP() {
		return CEP;
	}


	public void setCEP(String cEP) {
		CEP = cEP;
	}


	public List<Cliente> getCliente() {
		return cliente;
	}


	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}


	public List<Administrador> getAdministrador() {
		return administrador;
	}


	public void setAdministrador(List<Administrador> administrador) {
		this.administrador = administrador;
	}
	
	
	
}
