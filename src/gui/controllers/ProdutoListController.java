package gui.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Produto;

public class ProdutoListController implements Initializable{

	@FXML
	private Button btnAdicionar;
	
	@FXML
	private TableView<Produto> tblViewProduto;
	
	@FXML
	private TableColumn<Produto, Integer> tblColumnID;

	@FXML
	private TableColumn<Produto, String> tblColumnNome;

	@FXML
	private TableColumn<Produto, String> tblColumnDescricao;

	@FXML
	private TableColumn<Produto, Double> tblColumnPreco;

	@FXML
	private TableColumn<Produto, Integer> tblColumnQuantidade;

	@FXML
	private TableColumn<Produto, Date> tblColumnDataAdicao;
	@FXML
	public void onBtnAdicionarAction() {
		System.out.println("onBtnAdicionarAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tblColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tblColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tblColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("Descrição"));
		tblColumnPreco.setCellValueFactory(new PropertyValueFactory<>("Preco"));
		tblColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		tblColumnDataAdicao.setCellValueFactory(new PropertyValueFactory<>("Data de adição"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tblViewProduto.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
}
