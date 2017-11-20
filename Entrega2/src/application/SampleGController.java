package application;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


public class SampleGController {
	@FXML
	private ComboBox<String> tipos;
	@FXML
	private ComboBox<String> marcas;
	private Main main;
	public SampleGController(){	
	}
	@FXML
	private void initialize(){
		tipos.getItems().removeAll(tipos.getItems());
		tipos.getItems().addAll("capsulas","goteo","superautomáticas","espresso","italianas");
		tipos.getSelectionModel().select("capsulas");;
		marcas.getItems().removeAll(marcas.getItems());
		marcas.getItems().addAll("bosch", "deLonghi", "digrato", "krups", "monsial", "rushell", "saivod", "severin", "taurus", "ufesa", "jura", "miele", "philips", "saeco", "oster", "smeg", "solac", "tassimo", "jata", "orbegozo", "whirlpool", "illi", "moulinex", "ok", "electrolux", "wmf", "tristar", "menz&konecke");
		marcas.getSelectionModel().select("bosch");
	}
	public void setMain(Main main){
		this.main = main;
		
	}
}
