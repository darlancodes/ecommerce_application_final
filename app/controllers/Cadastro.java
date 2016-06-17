package controllers;

import play.mvc.*;

import java.util.ArrayList;
import java.util.List;

import models.*;
import play.data.Form;

public class Cadastro extends Controller{

	private final Form<Cliente> formCliente = Form.form(Cliente.class);
	//private final Form<Categoria> formCategoria = Form.form(Categoria.class);
	private final Form<Endereco> formEndereco = Form.form(Endereco.class);
	private final Form<Produto> formProduto = Form.form(Produto.class);
	//private final Form<ItemProduto> formItemProd = Form.form(ItemProduto.class);
	
	List<Categoria> categorias = Categoria.find.all();
	
	
	
	public Result novo()
	{
		return ok(views.html.teste.render(formCliente,formEndereco,formProduto,categorias));
	}
	
	public Result cadastrar()
	{
		
		Form<Cliente> formClienteRecebido = formCliente.bindFromRequest();
		//Form<Categoria> formCategoriaRecebido = formCategoria.bindFromRequest();
		Form<Endereco> formEnderecoRecebido = formEndereco.bindFromRequest();
		Form<Produto> formProdutoRecebido = formProduto.bindFromRequest();
		

		if(formClienteRecebido.hasErrors()){
		 flash("error", "Por favor corrija o formulário abaixo");
		}

		Cliente cliente = formClienteRecebido.get();
		Produto produto = formProdutoRecebido.get();
		Endereco endereco = formEnderecoRecebido.get();
		
		endereco.save();
		
		Carrinho carrinho = new Carrinho();
		carrinho.setCliente(cliente);
		carrinho.setItemproduto(new ArrayList<>());
		carrinho.setQuantidade(0);
		
		carrinho.save();
		
		cliente.setEndereco(endereco);
		cliente.setCarrinho(carrinho);
		
		cliente.save();
		produto.save();
		
		
		return ok(views.html.teste.render(formCliente,formEndereco,formProduto,categorias));
	}
	
	
}
