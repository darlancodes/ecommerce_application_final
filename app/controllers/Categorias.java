package controllers;

import java.util.List;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Categorias extends Controller{
	
	private final Form<Categoria> formCategoria = Form.form(Categoria.class);
	
	public Result novo(){
		
		return ok(views.html.cadastrocategoria.render(formCategoria));
	}
	
	public Result cadastrar(){
		
		Form<Categoria> formCategoriaRecebido = formCategoria.bindFromRequest();
		Categoria categoria = formCategoriaRecebido.get();
		
		categoria.save();
		
		flash("Ok", "Categoria Cadastrada com sucesso!");
		
		return ok(views.html.cadastrocategoria.render(formCategoria));
		
	}
	
	public Result editar(Long id){
		
		Categoria categoria = Categoria.find.byId(id);		
		
		Form<Categoria> formCategoriaFill = formCategoria.fill(categoria);
		
		return ok(views.html.editarproduto.render(formCategoria));
	}
	
	public Result atualizar(){
		
		Form<Categoria> formCategoriaRecebido = formCategoria.bindFromRequest();
		
		if(formCategoriaRecebido.hasErrors()){
			 flash("error", "Por favor corrija o formulário abaixo");
		}
		
		Categoria categoria = formCategoriaRecebido.get();
		categoria.update();
		
		
		return ok(views.html.cadastrocategoria.render(formCategoria));
	}
	
	public Result remover(Long id)
	{
		
		Categoria categoria = Categoria.find.byId(id);
		categoria.delete();
		return ok(views.html.cadastrocategoria.render(formCategoria));
		
	}
	
	

}
