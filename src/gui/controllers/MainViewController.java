package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.ProdutoService;

public class MainViewController implements Initializable {

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
		loadView("/gui/views/ProdutoList.fxml", (ProdutoListController controller) -> {
			controller.setProdutoService(new ProdutoService());
			controller.updateTableView();
		});
	}

	@FXML
	public void onMenuItemPedidoAction() {
		System.out.println("onMenuItemPedidoAction");
	}

	@FXML
	public void onMenuItemDescricaoAction() {
		loadView("/gui/views/Descricao.fxml", x -> {
		});
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	public synchronized <T> void loadView(String nomeAbsoluto, Consumer<T> iniciarFuncao) {
		try {
			// Carregar a nova tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
			// Carregar VBox da nova tela junto com seus elementos
			VBox newVBox = loader.load();

			// Abstrair a tela principal
			Scene mainScene = Main.getMainScene();
			// Abstrair a VBox da tela principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			// Guardar referência do menu da tela principal
			Node mainMenu = mainVBox.getChildren().get(0);

			// Excluir todos os elementos da VBox da tela principal
			mainVBox.getChildren().clear();

			// Adicionar o menu da tela principal
			mainVBox.getChildren().add(mainMenu);

			// Adicionar o VBox da nova tela
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			iniciarFuncao.accept(controller);
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Erro carregando a página", e.getMessage(), AlertType.ERROR);
		}
	}
}
