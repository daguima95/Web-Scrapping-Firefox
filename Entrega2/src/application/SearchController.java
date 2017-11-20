package application;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class SearchController {
	@FXML
	TableView<String> resultados;
	ArrayList<Cafetera> cafeteras = new ArrayList<Cafetera>();
	public SearchController(ArrayList<Cafetera> cafeteras){
		this.cafeteras = cafeteras;
		
	}
	@FXML
	private void initialize(){
		
		
	}
}
