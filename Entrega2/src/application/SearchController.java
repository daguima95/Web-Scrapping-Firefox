package application;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SearchController {
	@FXML
	TableView<String> resultados;
	private TableColumn<Cafetera, String> nombre;
	private TableColumn<Cafetera, String> precio;
	ArrayList<Cafetera> cafeteras = new ArrayList<Cafetera>();


	private SampleGController sampleGController;
	
	public SearchController(ArrayList<Cafetera> cafeteras){
		this.cafeteras = cafeteras;
		
	}
	@FXML
	private void initialize(){
		for(int i = 0; i < cafeteras.size(); i++) {
		nombre.setCellValueFactory(cellData -> cellData.getValue().cafetera[i].getNombre());
        precio.setCellValueFactory(cellData -> cellData.getValue().cafetera[i].getPrecio());
		}
	}
	
	public void setMain(SampleGController sampleGController2) {
		this.sampleGController = sampleGController2;
		
	}
	public void setStagePrincipal(Stage ventana) {
		
		
	}
	
}
