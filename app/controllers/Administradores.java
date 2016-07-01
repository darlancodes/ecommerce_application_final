package controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Administradores extends Controller{
	
	private final Form<Administrador> formAdm = Form.form(Administrador.class);
	private final Form<Endereco> formEndereco = Form.form(Endereco.class);
	private final Form<Cliente> formCliente = Form.form(Cliente.class);
	
	public Result novo(){
		
		return ok(views.html.cadastroadm.render(formAdm,formEndereco));
	}
	
	public Result cadastrar(){
		
		Form<Administrador> formAdmRecebido = formAdm.bindFromRequest();
		Form<Endereco> formEnderecoRecebido = formEndereco.bindFromRequest();
		
		if(formAdmRecebido.hasErrors()||formEnderecoRecebido.hasErrors()){
			 flash("error", "Por favor corrija o formulário abaixo");
		}
		
		Administrador adm = formAdmRecebido.get();
		Endereco endereco = formEnderecoRecebido.get();
		
		String hashSenha = BCrypt.hashpw(adm.getPassword(), BCrypt.gensalt());
		adm.setPassword(hashSenha);
		
		endereco.save();
		adm.setEndereco(endereco);
		adm.save();
		
		
		return ok(views.html.paineladm.render());
		
	}
	
	public Result editar(Long id){
		
		Administrador adm = Administrador.find.byId(id);
		Endereco endereco = adm.getEndereco();
		
		Form<Administrador> formAdmFill = formAdm.fill(adm);
		Form<Endereco> formEnderecoFill = formEndereco.fill(endereco);
		
		return ok(views.html.editaradm.render(formAdmFill,formEnderecoFill));
	}
	
	public Result atualizar(){
		
		Form<Administrador> formAdmRecebido = formAdm.bindFromRequest();
		Form<Endereco> formEnderecoRecebido = formEndereco.bindFromRequest();
		
		if(formAdmRecebido.hasErrors()||formEnderecoRecebido.hasErrors()){
			 flash("error", "Por favor corrija o formulário abaixo");
		}
		
		Administrador adm = formAdmRecebido.get();
		Endereco endereco = formEnderecoRecebido.get();
		
		endereco.save();
		adm.setEndereco(endereco);
		adm.update();
		
		
		return ok(views.html.paineladm.render());
	}
	
	public Result remover(Long id)
	{
		
		Administrador adm = Administrador.find.byId(id);
		Endereco endereco = adm.getEndereco();
		
		adm.delete();
		endereco.delete();
		
		flash("Ok", "Usuário Adm excluido com sucesso");
		
		return ok(views.html.cadastroadm.render(formAdm,formEndereco));
		
	}
	
	public Result removerCliente(Long id)
	{
		
		Cliente cliente = Cliente.find.byId(id);
		Endereco endereco = cliente.getEndereco();
		
		cliente.delete();
		
		if(endereco.getId()==cliente.getEndereco().getId()){
			endereco.delete();
		}
		
		flash("Ok", "Usuário cliente excluido com sucesso");
		
		return ok(views.html.cadastrocliente.render(formCliente,formEndereco));
		
	}
	
	public Result listaClientes()
	{
		List<Cliente> clientes = Cliente.find.all();
		return ok(views.html.listas.clientes.render(clientes));
	}
	
	public Result listaAdms()
	{
		List<Administrador> adms = Administrador.find.all();
		return ok(views.html.listas.administradores.render(adms));
	}
	
	public Result painelAdm(){
		
		return ok(views.html.paineladm.render());
	}
	
	public Result login(){
		
		return ok(views.html.loginadm.render(formAdm));
	}
	
	
	
	
	

}
