package gui.controllers;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Produto;
import model.services.ProdutoService;

public class ProdutoListController implements Initializable {

	private ProdutoService service;

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

	private ObservableList<Produto> obsList;

	@FXML
	public void onBtnAdicionarAction() {
		System.out.println("onBtnAdicionarAction");
	}

	public void setProdutoService(ProdutoService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tblColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tblColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tblColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		tblColumnPreco.setCellValueFactory(new PropertyValueFactory<>("Preco"));
		tblColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		tblColumnDataAdicao.setCellValueFactory(new PropertyValueFactory<>("DataAdicao"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tblViewProduto.prefHeightProperty().bind(stage.heightProperty());

	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service estava nulo");
		}
		List<Produto> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tblViewProduto.setItems(obsList);
	}
}
