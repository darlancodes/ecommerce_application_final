package controllers;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Administradores extends Controller{
	
	private final Form<Administrador> formAdm = Form.form(Administrador.class);
	private final Form<Endereco> formEndereco = Form.form(Endereco.class);
	
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
		
		endereco.save();
		adm.setEndereco(endereco);
		adm.save();
		
		
		return ok(views.html.cadastroadm.render(formAdm,formEndereco));
		
	}
	
	public Result editar(Long id){
		
		Administrador adm = Administrador.find.byId(id);
		Endereco endereco = adm.getEndereco();
		
		Form<Administrador> formAdmFill = formAdm.fill(adm);
		Form<Endereco> formEnderecoFill = formEndereco.fill(endereco);
		
		return ok(views.html.editarcadastroadm.render(formAdmFill,formEnderecoFill));
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
		
		
		return ok(views.html.cadastroadm.render(formAdm,formEndereco));
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
	
	
	
	

}
