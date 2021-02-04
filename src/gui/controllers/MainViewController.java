package gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemCliente;
	
	@FXML
	private MenuItem menuItemProduto;
	
	@FXML
	private MenuItem menuItemPedido;
	
	@FXML
	private MenuItem menuItemDescricao;
	
	@FXML
	public void onMenuItemClienteAction() {
		System.out.println("onMenuItemClienteAction");
	}
	
	@FXML
	public void onMenuItemProdutoAction() {
		System.out.println("onMenuItemProdutoAction");
	}
	
	@FXML
	public void onMenuItemPedidoAction() {
		System.out.println("onMenuItemPedidoAction");
	}
	
	@FXML
	public void onMenuItemDescricaoAction() {
		System.out.println("onMenuItemDescricaoAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
