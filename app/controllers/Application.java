package controllers;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model.Finder;

import play.*;
import play.data.Form;
import play.mvc.*;
import models.*;
import views.html.*;

public class Application extends Controller {
	
    public Result index() {
    	List<Produto> produtos = Produto.find.all();	
    	List<Categoria> categorias = Categoria.find.all();
        return ok(views.html.index.render(produtos,categorias,"Log in"));
    }
    
    private final Form<Login> formLogin = Form.form(Login.class);
    
    public Result login(){
    	
    	List<Produto> produtos = Produto.find.all();	
    	List<Categoria> categorias = Categoria.find.all();
    	
    	Form<Login> formLoginRecebido = formLogin.bindFromRequest();
    	
    	Login login = formLoginRecebido.get();
    	
    	List<Cliente> clientes = Cliente.find.all();
    	
    	for(Cliente cliente:clientes){
    		
    		if(cliente.getEmail().equals(login.getLogin())){
    			
    			if(BCrypt.checkpw(login.getPassword(), cliente.getPassword()) == true){
    				
    				session("conectado",cliente.getNome());
    				String user =  session("conectado");
    			    if(user != null) {
    			    	return ok(views.html.index.render(produtos,categorias,cliente.getNome()));
    			    } else {
    			    	return ok(views.html.index.render(produtos,categorias,"Log in"));
    			    }
    				
    			}else{
    				return ok(views.html.index.render(produtos,categorias,"Log in"));
    			}
    		}
    	}
    	
    	return ok(views.html.index.render(produtos,categorias,"Log in"));
    }
}

