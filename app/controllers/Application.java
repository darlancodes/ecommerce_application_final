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
        return ok(views.html.index.render(produtos,categorias));
    }
    
    private final Form<Login> formlogin = Form.form(Login.class);
    
    public Result login(){
    	
    	Form<Login> formLoginRecebido = formlogin.bindFromRequest();
    	
    	Login login = formLoginRecebido.get();
    	
    	List<Cliente> clientes = Cliente.find.all();
    	
    	for(Cliente cliente:clientes){
    		//System.out.println(cliente.getEmail() +" "+ login.getLogin());
    		if(cliente.getEmail().equals(login.getLogin())){
    			
    			if(BCrypt.checkpw(login.getPassword(), cliente.getPassword()) == true){
    				
    				session("conectado",cliente.getEmail());
    				String user = session("conectado");
    			    if(user != null) {
    			        return ok("Hello " + cliente.getNome());
    			    } else {
    			        return unauthorized("Oops, you are not connected");
    			    }
    				
    			}else{
    				return unauthorized("Oops, you are not connected");
    			}
    		}
    	}
    	
    	return unauthorized("Oops, you are not connected");
    }
}

