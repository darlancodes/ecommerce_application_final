package controllers;
import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Clientes extends Controller{

	private final Form<Cliente> formCliente = Form.form(Cliente.class);
	private final Form<Endereco> formEndereco = Form.form(Endereco.class);
	
	public Result novo(){
		
		return ok(views.html.cadastrocliente.render(formCliente,formEndereco));
	}
	
	public Result cadastrar(){
		
		Form<Cliente> formClienteRecebido = formCliente.bindFromRequest();
		Form<Endereco> formEnderecoRecebido = formEndereco.bindFromRequest();
		
		if(formClienteRecebido.hasErrors()||formEnderecoRecebido.hasErrors()){
			 flash("error", "Por favor corrija o formulário abaixo");
		}
		
		Cliente cliente = formClienteRecebido.get();
		Endereco endereco = formEnderecoRecebido.get();
		Carrinho carrinho = new Carrinho();
		
		endereco.save();
		carrinho.save();
		cliente.setEndereco(endereco);
		cliente.setCarrinho(carrinho);
		cliente.save();
		
		
		return ok(views.html.cadastrocliente.render(formCliente,formEndereco));
		
	}
	
	public Result editar(Long id){
		
		Cliente cliente = Cliente.find.byId(id);
		Endereco endereco = cliente.getEndereco();
		
		Form<Cliente> formClienteFill = formCliente.fill(cliente);
		Form<Endereco> formEnderecoFill = formEndereco.fill(endereco);
		
		return ok(views.html.editarcliente.render(formClienteFill,formEnderecoFill));
	}
	
	public Result atualizar(){
		
		Form<Cliente> formClienteRecebido = formCliente.bindFromRequest();
		Form<Endereco> formEnderecoRecebido = formEndereco.bindFromRequest();
		
		if(formClienteRecebido.hasErrors()||formEnderecoRecebido.hasErrors()){
			 flash("error", "Por favor corrija o formulário abaixo");
		}
		
		Cliente cliente = formClienteRecebido.get();
		Endereco endereco = formEnderecoRecebido.get();
		
		endereco.save();
		cliente.setEndereco(endereco);
		cliente.update();
		
		
		return ok(views.html.cadastrocliente.render(formCliente,formEndereco));
	}
	
	public Result remover(Long id)
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
	
}
