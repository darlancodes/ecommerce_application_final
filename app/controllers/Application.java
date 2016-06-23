package controllers;

import java.util.ArrayList;
import java.util.List;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model.Finder;

import play.*;
import play.mvc.*;
import models.*;
import views.html.*;

public class Application extends Controller {

	List<Produto> produtos = Produto.find.all();	
	
    public Result index() {
        return ok(views.html.index.render(produtos));
    }
    
}

