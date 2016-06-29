package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import models.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

public class Produtos extends Controller{
	
	private final Form<Produto> formProduto = Form.form(Produto.class);
	List<Categoria> categorias = Categoria.find.all();
	
	public Result novo(){
		
		return ok(views.html.cadastroproduto.render(formProduto,categorias));
	}
	
	public Result cadastrar(){
		
		Form<Produto> formProdutoRecebido = formProduto.bindFromRequest();
		Produto produto = formProdutoRecebido.get();
		
		if(uploadFoto()!="Erro"){
			produto.setFoto(uploadFoto());
		}
		
		produto.save();
		
		flash("Ok", "Usuário Adm excluido com sucesso");
		
		return ok(views.html.cadastroproduto.render(formProduto,categorias));
		
	}
	
	public String uploadFoto(){
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart picture = body.getFile("foto");
		    	
		if(picture != null) {
	
			String assetsDir = File.separator + "assets" + File.separator + "images" + File.separator;
		    String fileName = picture.getFilename();
		    String contentType = picture.getContentType();
		    File file = picture.getFile();
		    
		    String appDir = System.getProperty("user.dir");	
		    String newPath = appDir + File.separator + "public" + File.separator + "images" + File.separator + fileName;	
		    File newFile = new File(newPath);
		    		
		    try {
		        Files.move(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		        return assetsDir + fileName;
		        
		    } catch(IOException e) {
		    	e.printStackTrace();
		    }
		    return assetsDir + fileName;
		    } else {
		    	flash("error", "Missing file");
		    	return "Erro";
		    }	
	 }

}
