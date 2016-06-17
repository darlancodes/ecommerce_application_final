package controllers;

import play.mvc.*;
import models.*;
import play.data.Form;

public class Cadastro extends Controller{

	private final Form<Cliente> formCliente = Form.form(Cliente.class);
	private final Form<Categoria> formCategoria = Form.form(Categoria.class);
	private final Form<Endereco> formEndereco = Form.form(Endereco.class);
	private final Form<Produto> formProduto = Form.form(Produto.class);
	//private final Form<ItemProduto> formItemProd = Form.form(ItemProduto.class);
	
	public Result novo()
	{
		return ok(views.html.teste.render(formCliente,formEndereco,formCategoria,formProduto));
	}
	
	public Result cadastrar()
	{
		
//		Form<Espaconave> formEnviado = formEspaconave.bindFromRequest();
//
//		if(formEnviado.hasErrors()){
//		 flash("error", "Por favor corrija o formulário abaixo");
//		}
//
//		Espaconave espaconave = formEnviado.get();
//		espaconave.save();
//		flash("error", "Planeta Não encontrado");
		return ok(views.html.teste.render(formCliente,formEndereco,formCategoria,formProduto));
	}
	
	
}
