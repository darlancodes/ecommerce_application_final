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
	
	
	
	
	
	
	

}
